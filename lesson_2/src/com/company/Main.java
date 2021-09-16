package com.company;
// Задача 1
//Выведите  номера столбцов, элементы каждой
// из которых образуют монотонную последовательность
// (монотонно убывающую или монотонно возрастающую).

// Задача 2
//Подсчитать количество строк заданной матрицы, являющихся перестановкой чисел
// -1, -2, -3

// Задача 3
//Переставляя ее строки и столбцы,  добиться,
//чтобы наименьший элемент  (один  из них) оказался в нижнем правом углу.
//Вывести на экран полученную матрицу.

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n****Task_1****\n");
        task_1();
        System.out.println("\n****Task_2****\n");
        task_2();
        System.out.println("\n****Task_3****\n");
        task_3();
    }
    public static void task_1()
    {
        Matrix_1 m = new Matrix_1();
        m.generating();
        m.printing();
        ArrayList<Integer> c = m.monotone();
        System.out.println("The numbers of rows that are monotone: ");
        for(Integer i: c)
        {
        System.out.print(i+" ");
        }
    }
    public static void task_2() {
        Matrix_2 m_2 = new Matrix_2();
        m_2.input();
        m_2.printing();
        System.out.println("The numbers of lines that are permutations: ");
        System.out.println(m_2.permutations());
    }
    public static void task_3() {
        Matrix_3 m_3 = new Matrix_3();
        m_3.generating();
        m_3.printing();
        ArrayList<Integer> indexes = m_3.find_min_element();
        m_3.row_change(indexes.get(0));
        m_3.line_change(indexes.get(1));
        m_3.printing();

    }
}
