package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    Matrix_1 m = new Matrix_1();
    m.generating();
    m.printing();
    ArrayList<Integer> c = m.monotone();
    for(Integer i: c)
    {
        System.out.println(i);
    }
    }

}
