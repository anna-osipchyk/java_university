package com.company;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.stream.Collectors;
public class Task_2 {
    public static void solve()
    {
        Pattern pattern;
        pattern = Pattern.compile("_*[0-9]+_*[A-Z]+_*[a-z]+_*");
        Matcher matcher;
        String []string = {"MemLo_l9999___", "33aA_", "aaaa99999OOOO0OOO", "0a01Jdsjs9xjd_", "12345ASD"};
        for (String s: string)
        {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            matcher = pattern.matcher(str);
            boolean flag = matcher.matches();
            if(flag&& s.length()>=8)
            {
                System.out.println(s);
            }

        }

    }

}

