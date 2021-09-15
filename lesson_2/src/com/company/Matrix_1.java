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

    public void printing() {
        System.out.println("Your matrix: ");
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
            Integer tmp = matrix.get(j).get(0);
            boolean flag = false;
            for (int i = 0; i< dim-1; i++)
            {
                if((tmp > matrix.get(j).get(i) && matrix.get(j).get(i) <matrix.get(j).get(i+1))||(tmp < matrix.get(j).get(i) && matrix.get(j).get(i) >matrix.get(j).get(i+1)))
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


