package com.company;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.stream.Collectors;
//В текстовом файле input.txt в записаны строки, в
// которых есть скобки. Удалить в каждой строке текст в
// одинарных скобках и эти скобки. Если есть вложенность,
// текст во вложенных скобках  не изменять.
// Использовать  String,  StringBuffer и StringTokenizer.
//


public class Task_1 {
    public static void solv() throws Exception
    {
        FileReader f = new FileReader("input.txt");
        Scanner sc = new Scanner(f);
        String s;
        int counter_of_right_brackets=0, counter_of_left_brackets = 0;
        List<String> list = new ArrayList<String>();
        boolean flag = false;
        List<Character> arr_final = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        while(sc.hasNextLine())
        {
            s = sc.nextLine();
            String tmp;
            flag = false;
            char [] ch_arr = s.toCharArray();
            counter_of_right_brackets=0;
            counter_of_left_brackets=0;

        for(int i = 0; i< ch_arr.length; i++) {
            if (!flag && ch_arr[i]=='(')
            {
                ch_arr[i]='0';
                counter_of_right_brackets++;
                flag = true;
                i++;
                while(ch_arr[i]!=')')
                {
                    if(ch_arr[i]=='(')
                    {
                        while(counter_of_right_brackets-counter_of_left_brackets!=1 || counter_of_right_brackets==1)
                        {
                            if(ch_arr[i]==')'){
                                counter_of_left_brackets++;
                            }
                            else if (ch_arr[i]=='(')
                            {
                                counter_of_right_brackets++;
                            }
                            i++;
                        }
                    }
                    ch_arr[i] = '0';
                    i++;
                }
                flag = false;
                if(ch_arr[i] == '('){
                    counter_of_right_brackets+=1;
                }
                else if(ch_arr[i]==')')
                {
                    counter_of_left_brackets+=1;
                }
                if (counter_of_left_brackets==counter_of_right_brackets&& ch_arr[i]==')')
                {
                    ch_arr[i]='0';
                }

            }

        }
            for (char c : ch_arr) {
                chars.add(c);
            }
        }
        chars.removeIf(ch-> ch.equals('0'));
        String listString = chars.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        System.out.println(listString);
        }


}
