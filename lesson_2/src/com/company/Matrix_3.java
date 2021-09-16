package com.company;
import java.util.*;
public class Matrix_3 {
    private int dim;
    private Vector<Vector<Integer>> matrix;

    public void generating() {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        System.out.println("\nEnter the dimension of your matrix, please: ");
        dim = scn.nextInt();
        System.out.println("Your matrix is generating..");
        matrix = new Vector<>();
        Vector<Integer> tmp = new Vector<>();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                tmp.add(rnd.nextInt(100));
            }
            matrix.add(tmp);
            tmp = new Vector<>();
        }

    }
    public ArrayList<Integer> find_min_element() {
        Integer temp = matrix.get(0).get(0);
        ArrayList<Integer> answ =new ArrayList<>();
        Integer i_min = 0, j_min = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (matrix.get(i).get(j) <= temp) {
                    temp = matrix.get(i).get(j);
                    i_min = i;
                    j_min = j;
                }
            }

        }
        answ.add(i_min);
        answ.add(j_min);
        return answ;
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
    public void row_change(int j) {
        Vector<Integer> temp = matrix.get(dim-1);
        matrix.set(dim-1, matrix.get(j));
        matrix.set(j, temp);

    }
    public void line_change(int i_min){
        Vector<Integer> temp = new Vector<>();
        for(int j = 0; j<dim; j++)
        {
            temp.add(matrix.get(j).remove(i_min));
        }
        for(int i = 0; i<dim; i++)
        {
            matrix.get(i).add(temp.remove(0));

        }
    }

    }

