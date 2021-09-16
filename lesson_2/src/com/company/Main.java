package com.company;
// Задача 1
//Выведите  номера столбцов, элементы каждой
// из которых образуют монотонную последовательность
// (монотонно убывающую или монотонно возрастающую).

// Задача 2
//Подсчитать количество строк заданной матрицы, являющихся перестановкой чисел
// -1, -2, -3
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        task_1();
        task_2();
    }
    public static void task_1()
    {
        Matrix_1 m = new Matrix_1();
        m.generating();
        m.printing();
        ArrayList<Integer> c = m.monotone();
        System.out.println("The numbers of rows that are momotone: ");
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
}
