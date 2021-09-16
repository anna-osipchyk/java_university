package com.company;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix_2 {
    private final int dim = 3;
    private int [][] matrix;
    Pattern pattern = Pattern.compile("\\[-[1-3], -[1-3], -[1-3]]");
    public void input() {
        matrix = new int[dim][dim];
        Scanner scn = new Scanner(System.in);
        System.out.println("\nBe ready to input the elements of matrix...");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.println("Enter the element: ");
                matrix[i][j] = scn.nextInt();
            }
        }
    }
        public ArrayList<Integer> permutations()
    {
        ArrayList<Integer> list_of_perms = new ArrayList<>();
        String string;

        for(int i=0;i< dim;i++)
        {
            string = Arrays.toString(matrix[i]);
            Matcher matcher = pattern.matcher(string);
            boolean found = matcher.matches();
            if (found) {
                list_of_perms.add(i);

            }
        }
    return list_of_perms;
    }
    public void printing() {
        System.out.println("\nYour matrix: ");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
