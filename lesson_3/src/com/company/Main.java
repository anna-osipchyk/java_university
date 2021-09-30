package com.company;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("\n****Task_1****\n");
        task_1();
        task_2();
       System.out.println("\n****Task_2****\n");
        task_2();
    }
    public static void task_1()
    {

        FirstTask t_1 = new FirstTask();
        t_1.input();
        t_1.solve();
    }
    public static void task_2() throws Exception
    {

        SecondTask t_2 = new SecondTask();
        t_2.solve();

    }

}
