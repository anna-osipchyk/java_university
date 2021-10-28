package com.company;
import java.util.*;
import java.io.*;
import java.util.regex.*;
class ScannerWriter
{
    private FileWriter fw;
    ScannerWriter() throws Exception
    {

        this.fw = new FileWriter("output.txt");


    }
    public void writeScanner(String s) throws Exception
    {
        this.fw.write(s);
    }
    public void close() throws Exception
    {
        fw.close();
    }


}

public class Binary_nums {
    public static void solve_1() throws Exception
    {
        File file = new File("sample");
        Scanner sc = new Scanner(file);
        ArrayList<String> text =  new ArrayList<>();
        while(sc.hasNextLine())
        {
            text.add(sc.nextLine());
        }
        ScannerWriter sw = new ScannerWriter();
        for(String s: text)
        {
            sw.writeScanner(s);
        }
        sc.close();
        sw.close();

    }
    public static void solve_2() throws Exception
    {
//        6.1. Разработать программу для проверки текстового файла на наличие чисел 2 с\с,.
//        Программа должна создать и записать в разных двух файлах, соответственно, найденные числа
//        (через пробел)
//        и всё остальное.
        FileReader fr = new FileReader("sample_1");
        FileWriter fw_1 = new FileWriter("output_1");
        FileWriter fw_2 = new FileWriter("output_2");
        Scanner sc = new Scanner(fr);
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("[10]+");
        while(sc.hasNextLine())
        {
            String s= sc.nextLine();
            matcher = pattern.matcher(s);
            while(matcher.find())
            {
                int start = matcher.start();
                int end = matcher.end();
                System.out.println(s.substring(start, end));
                fw_1.write(s.substring(start, end)+ " ");
            }
            String other_nums []=s.split("[10]+");
            for(String str: other_nums)
            {
                fw_2.write(str);
            }


        }
        fw_1.close();
        fw_2.close();
    }


}
