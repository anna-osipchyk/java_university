package com.company;
import java.util.*;
//Разработать проект для использования класса Matrix.
//        Поменять  в к-том столбце матрицы строки с мах и мин элементами.
//        Вывести на экран исходную и полученную матрицы.
//        Создать  массив объектов матриц для обработки
//        Основные методы класса:
//public Matrix(int _rows, int _columns)
//public void print()
//public void setRandom(int n){
//public int getMaxRow( int k
//public int getMinRow(int k
//public void swapRows(int row1, int row2
//public void printMinItems


public class Matrix {
    private int dim;
    private ArrayList<ArrayList<Integer>> matrix;

    public void SetRandom(int dim) {
        this.dim = dim;
        Random rnd = new Random();
        matrix = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                tmp.add(rnd.nextInt(10));
            }
            matrix.add(tmp);
            tmp = new ArrayList<>();
        }

    }
    public Matrix(int dim) {
        this.dim = dim;
        Scanner scn = new Scanner(System.in);
        System.out.println("\nBe ready to input the elements of matrix...");
        matrix = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.println("Enter the element: ");
                tmp.add(scn.nextInt());
            }
            matrix.add(tmp);
            tmp = new ArrayList<>();
        }

    }
    public void print() {
        System.out.println("\nYour matrix: ");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int getMaxRow(int k)
    {
        assert(k>dim-1 && k <0);
//        int max = Collections.max(matrix.get(k));
//        return matrix.get(k).indexOf(max);
        int max = matrix.get(0).get(k);
        int idx = 0;
        for (int i = 0; i< dim; i++)
        {
            if(matrix.get(i).get(k)> max)
            {
                max = matrix.get(i).get(k);
                idx = i;
            }
        }return idx;
    }
    public int getMinRow(int k)
    {
        assert(k>dim-1 && k <0);
//        int max = Collections.max(matrix.get(k));
//        return matrix.get(k).indexOf(max);
        int min = matrix.get(0).get(k);
        int idx = 0;
        for (int i = 0; i< dim; i++)
        {
            if(matrix.get(i).get(k)< min)
            {
                min = matrix.get(i).get(k);
                idx = i;
            }
        }return idx;
    }
    public void swapRows(int row_1, int row_2)
    {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp = new ArrayList<>(matrix.get(row_1));
        matrix.set(row_1, matrix.get(row_2));
        matrix.set(row_2, tmp);

    }
    public void printMinElements()
    {
        System.out.println("Your minimal elements: ");
        int min = matrix.get(0).get(0);
        for(int i =0;i<dim; i++)
        {
         int tmp = Collections.min(matrix.get(i));
         if (tmp<min)
         {
             min = tmp;
         }
        }
        for(int i=0;i< dim;i++)
        {
            for(int j =0; j< dim; j++)
            {
                if (matrix.get(i).get(j) == min)
                {
                    System.out.print(min + "\n");
                }
            }
        }
    }

}


