package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileWriter;

class ScannerWriter {
    private FileWriter fw = new FileWriter("output.txt");

    ScannerWriter() throws Exception {
    }

    public void writeScanner(String s) throws Exception {
        this.fw.write(s);
    }

    public void close() throws Exception {
        this.fw.close();
    }
}

public class Binary{
    public Binary() {
    }

    public static void solve_1() throws Exception {
        File file = new File("sample");
        Scanner sc = new Scanner(file);
        ArrayList text = new ArrayList();

        while(sc.hasNextLine()) {
            text.add(sc.nextLine());
        }

        ScannerWriter sw = new ScannerWriter();
        Iterator var4 = text.iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            sw.writeScanner(s);
        }

        sc.close();
        sw.close();
    }

    public static void solve_2() throws Exception {
        FileReader fr = new FileReader("sample_1");
        FileWriter fw_1 = new FileWriter("output_1");
        FileWriter fw_2 = new FileWriter("output_2");
        Scanner sc = new Scanner(fr);
        Pattern pattern = Pattern.compile("[10]+");

        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            Matcher matcher = pattern.matcher(s);

            while(matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                System.out.println(s.substring(start, end));
                String var10001 = s.substring(start, end);
                fw_1.write(var10001 + " ");
            }

            String[] other_nums = s.split("[10]+");
            String[] var13 = other_nums;
            int var9 = other_nums.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                String str = var13[var10];
                fw_2.write(str);
            }
        }

        fw_1.close();
        fw_2.close();
    }
}
