package com.company;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class GardenTree implements Serializable

{
    private static final long serialVersionUID = 1L;
    static transient ArrayList<String> fruiting_periods = new ArrayList<>();
    static transient int index = 0;
    static transient Locale locale;
    static transient ResourceBundle rb;
    int number = 0;
    protected Date date_of_creation;
    protected String name;
    protected int age;
    protected boolean is_transplant;
    protected String fruiting;
    public static void set_locals(String loc, String LOC)
    {
        locale = new Locale(loc, LOC);
        rb = ResourceBundle.getBundle("text", locale);
    }

    public GardenTree(int age)
    {
        if (index == 0)
        {
            fruiting_periods.add(rb.getString("text.grow_period_1"));
            fruiting_periods.add(rb.getString("text.grow_period_2"));
            fruiting_periods.add(rb.getString("text.grow_period_3"));
        }
    try {

        if (age > 0) {

            index += 1;
            this.number = index;
            this.age = age;
            this.name = rb.getString("text.tree");
            this.is_transplant = false;
            this.date_of_creation = new Date();
        } else {
            throw new Exception(rb.getString("text.exception_data"));
        }
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());
        }

    }

    public void change_age(int year)
    {

        try {
            if (year > 0) {
                this.age += year;
                System.out.println(rb.getString("text.tree_is_growing"));
            } else {
                throw new Exception(rb.getString("text.exception_data"));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void set_fruiting()
    {

        if (this.age > 0 && this.age < 10) {
            this.fruiting = fruiting_periods.get(0);
        } else if (this.age >= 10 && this.age < 50) {
            this.fruiting = fruiting_periods.get(1);
        } else if (this.age >= 50 && this.age < 70) {
            this.fruiting = fruiting_periods.get(2);
        } else if (this.age >= 70) {
            System.out.println(rb.getString("text.tree_is_dead"));
        }
    }
    public void make_decision()
    {

        if (Objects.equals(this.fruiting, fruiting_periods.get(0)) && !this.is_transplant)
        {
            this.is_transplant = true;
            System.out.println(rb.getString("text.ready_to_grow"));
        }
        else if(Objects.equals(this.fruiting, fruiting_periods.get(1)) && !this.is_transplant)
        {
            this.is_transplant = true;
            System.out.println(rb.getString("text.ready_to_fruit"));
        }
        else if(Objects.equals(this.fruiting, fruiting_periods.get(2)) && !this.is_transplant)
        {
            this.is_transplant = true;
            System.out.println(rb.getString("text.ready_to_die"));
        }
        else
        {
            System.out.println(rb.getString("text.no_need_to_transplant"));

        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        return "{" + rb.getString("text.date_of_creation") + ": " + formatForDateNow.format(date_of_creation)+
                ", " + rb.getString("text.number")+ ": " + number + ", "+
                rb.getString("text.age")+ ": " + age + ", "+
                rb.getString("text.grow_period_1") + ": "+ fruiting + "\n}";
    }
}
