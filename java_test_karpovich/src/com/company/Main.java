package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Students s = new Students();
        s.read_from_file();
        s.validation();
        s.new_file();
        String point = s.overall_point();
        System.out.println("Средний балл по группе: " + point);
        s.sort();
    }
}
