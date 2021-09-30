package com.company;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//
//Задан текстовый файл input.txt.
//Требуется определить строки этого файла
//содержащие максимальную по длине подстроку, состоящую только из цифр.
//Если таких строк несколько, найти первые 10
//Результат вывести на консоль в форме, удобной для чтения.

public class SecondTask {

    public void solve() throws Exception
    {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher m;
        String s;

        FileReader f = new FileReader("sample.txt");

        Scanner sc = new Scanner(f);
        ArrayList<Integer> length_of_each_row = new ArrayList<>();
        int i = 0;
        while (sc.hasNextLine())
        {
            s = sc.nextLine();
            m = pattern.matcher(s);
            int difference = 0;
            while(m.find())
            {
                if(m.end()-m.start() > difference)
                {
                    difference = m.end()-m.start();
                }
            }
            length_of_each_row.add(difference);

        }
        f.close();
        System.out.println("Номер строки с максимальной подстрокой из цифр: ");
        int max =Collections.max(length_of_each_row);
        for(int j =0; j<length_of_each_row.size(); j++)
        {
            if(length_of_each_row.get(j) == max)
            System.out.println(j+1);

        }
    }
}
