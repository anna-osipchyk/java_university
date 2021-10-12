package com.company;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.stream.Collectors;

public class Task_1 {
//    private static Pattern pattern_1;
//    private static Matcher matcher_1;
//    public static void solve() throws Exception
//    {
//        FileReader f = new FileReader("input.txt");
//        Scanner sc = new Scanner(f);
//        String s;
//        List<String> list = new ArrayList<String>();
//
//        List<String> list_1 = new ArrayList<String>();
//        while(sc.hasNextLine())
//        {
//            s = sc.nextLine();
//            pattern_1 = Pattern.compile("\\(.+?\\)");
//            Pattern pattern_2 = Pattern.compile("\\(.+?\\(");
//            Pattern pattern_3 = Pattern.compile("\\).+?\\)");
//
//            //String[] tmp_arr_of_str = pattern_1.split(new String(s));
//            String[] tmp_arr_of_str_2 = pattern_2.split(s);
//            String[] tmp_arr_of_str_3 = pattern_3.split(Arrays.toString(tmp_arr_of_str_2));
//            list_1.addAll(Arrays.asList(tmp_arr_of_str_3));
//
//            list.addAll(Arrays.asList(tmp_arr_of_str_2));
//
//        }
//    for(String string: list_1 )
//    {
//        System.out.print(string);
//    }
//
//    }
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
                counter_of_right_brackets++;
                flag = true;
                i++;
                while(ch_arr[i]!=')' && ch_arr[i]!='\n')
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

            }

        }
            for (char c : ch_arr) {
                chars.add(c);
            }
        }
        String listString = chars.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        System.out.println(listString);
        //System.out.println(chars.toString());
        }
//    public static void solution() throws Exception {
//
//        FileReader f = new FileReader("input.txt");
//        Scanner sc = new Scanner(f);
//        ArrayList<String> arr_of_s = new ArrayList<>();
//        String tmp;
//
//        while (sc.hasNextLine()) {
//            tmp = sc.nextLine();
//            String[] tmp_arr_of_str_2 = tmp.split(" ");
//            arr_of_s.addAll(Arrays.asList(tmp_arr_of_str_2));
//        }
//        for (String str: arr_of_s)
//        {
//            System.out.println(str);
//        }
//    }


}
