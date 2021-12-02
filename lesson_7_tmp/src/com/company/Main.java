package com.company;

import java.io.*;
import java.util.*;
import java.lang.System;
public class Main {
    public static void main(String[] args) throws Exception
    {
        HashMap<String, String> locals = new HashMap<>();
        locals.put("ru", "RU");
        locals.put("en", "EN");
        locals.put("bel", "BY");
        Scanner in = new Scanner(System.in);
        System.out.print("Добро пожаловать в Интерактивный сад! Пожалуйста, выберите язык приложения: \n" +
                "ru - русский\n" +
                "en - english\n"+
                "bel - белорусский\n"
            );

        String language = in.nextLine();
        if (locals.containsKey(language))
        {
            String loc = locals.get(language);
        }
        else{
            System.out.println("Неверные данные");
            System.exit(0);
        }
        in.close();

        GardenTree.set_locals(language, locals.get(language));
        GardenTree gt1 = new GardenTree(10);
        Thread.sleep(1000);
        GardenTree gt2 = new GardenTree(15);
        Thread.sleep(1000);
        AppleTree at1 = new AppleTree(20);
        Thread.sleep(1000);
        AppleTree at2 = new AppleTree(60);
        gt1.change_age(30);
        at1.change_age(5);
        gt1.set_fruiting();
        gt2.set_fruiting();
        at1.set_fruiting();
        at2.set_fruiting();
        gt1.make_decision();
        gt2.make_decision();
        at1.make_decision();
        at2.make_decision();
        Locale locale = new Locale(language, locals.get(language));
        ResourceBundle rb = ResourceBundle.getBundle("text", locale);
        System.out.println(gt1.toString());
        System.out.println(gt2.toString());
        System.out.println(at1.toString());
        String filename = "trees.dat";

        // создадим список объектов, которые будем записывать
        ArrayList<GardenTree> trees = new ArrayList<GardenTree>();
        trees.add(gt1);
        trees.add(gt2);
        serialize(trees, filename);
        deserialize(filename,"trees.txt");
        ArrayList<AppleTree> apple_trees = new ArrayList<AppleTree>();
        apple_trees.add(at1);
        apple_trees.add(at2);
        serialize(apple_trees, filename);
        deserialize(filename,"apple_trees.txt");

    }
    public static void serialize(ArrayList trees, String filename)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(trees);
        }
        catch(OutOfMemoryError ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
    public static void deserialize(String from_filename, String to_filename)
    {
        ArrayList<GardenTree> newTrees= new ArrayList<GardenTree>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(from_filename)))
        {

            newTrees= ((ArrayList<GardenTree>) ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(GardenTree gt : newTrees)
            System.out.println(gt.toString());

        FileWriter fw = null;
        try {
            fw = new FileWriter(to_filename);
            for(GardenTree gt : newTrees)
                fw.write(gt.toString());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{

            try{

                if(fw!=null)
                    fw.close();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }


}





