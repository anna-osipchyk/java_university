package com.company;
import java.util.*;
public class Matrix_1 {
    private int dim;
    private ArrayList<ArrayList<Integer>> matrix;

    public void generating() {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the dimension of your matrix, please: ");
        dim = scn.nextInt();
        System.out.println("Your matrix is generating..");
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
    public void input() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the dimension of your matrix, please: ");
        dim = scn.nextInt();
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
    public void printing() {
        System.out.println("\nYour matrix: ");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> monotone() {
        ArrayList<Integer> rows = new ArrayList<>();
        for (int j = 0; j< dim; j++)
        {
            Integer tmp = matrix.get(0).get(j);
            boolean flag = false;
            for (int i = 0; i< dim-1; i++)
            {
                if((tmp > matrix.get(i).get(j) && matrix.get(i).get(j) <matrix.get(i+1).get(j))||(tmp < matrix.get(i).get(j) && matrix.get(i).get(j) >matrix.get(i+1).get(j)))
                {
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                rows.add(j);
            }
        }
return rows;
    }

}


