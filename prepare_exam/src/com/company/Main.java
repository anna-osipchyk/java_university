package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args)  throws Exception{

        FileInputStream inputStream2 = new FileInputStream("input2.txt");
        FileReader fr = new FileReader("input1.txt");
        Scanner sc = new Scanner(fr);
        int size = sc.nextInt();
        sc.close();
        int count = 0;
        byte[] buffer = new byte[1000];
        while (inputStream2.available()>0)
        {
            count += inputStream2.read(buffer);
        }
        int number_of_files = task_1(count, size);
        ArrayList<String> files = task_2("input2.txt", number_of_files);
        task_3(size,count,files,buffer);
        task_4(buffer,count,"input2.txt");

    }
    public static int task_1(double count, double size)  throws Exception {
        FileWriter fw = new FileWriter("output1.txt");
        int result = (int) Math.ceil(count/size);
        fw.write(Integer.toString(result));
        fw.close();
        return result;
    }
    public static ArrayList<String> task_2(String pathname, int number_of_files) throws Exception {
        FileWriter fw = new FileWriter("output2.txt");
        ArrayList<String> files = new ArrayList<>();
        for(int i=number_of_files;i>0; i--)
        {
            String string_pattern= i +"#"+pathname;
            if (i!=1) {
                string_pattern+="\n";
            }
            fw.write(string_pattern);
            files.add(string_pattern);

        }
        fw.close();
        return files;
    }
    public static void task_3(int size, int count, ArrayList<String> files, byte [] buffer) throws Exception {

        int start = 0;
        for(int i = files.size()-1;i>=0;i--)
        {
            FileOutputStream fos = new FileOutputStream(files.get(i));
                if (count-start<size)
                {
                    fos.write(buffer, start, count-start);
                }
               else
                {
                    fos.write(buffer, start, size);
                }
                start += size;
               fos.close();

        }

    }
    public static void task_4(byte [] buffer, int count, String pathname) throws Exception {
        String path = "%"+pathname;
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(buffer,0,count);
        fos.close();
    }
}