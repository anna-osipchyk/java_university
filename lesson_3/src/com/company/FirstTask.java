package com.company;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Строка состоит из слов, разделенных ровно одним пробелом,
//пробелов перед первым и после последнего слова нет.
//Поместить в начало строки слова, содержащие только цифры, а
//затем – все остальные слова. Порядок слов внутри заданных
//групп не должен изменяться. Слова в исходной строке разделяются
//некоторым множеством разделителей. Слова в новой строке должны разделяться ровно одним пробелом.

public class FirstTask {
    private static Pattern pattern_1;
    private static Pattern pattern_2;
    private String s;
    public void input()
    {
        pattern_1 = Pattern.compile("( ?[0-9] ?)+");
        pattern_2 = Pattern.compile("( ?[a-zA-Zа-яА-Я] ?)+");
        Scanner sc  =new Scanner(System.in);
        System.out.println("Введите, пожалуйста, строку, слова которой разделены пробелами: ");
        s = sc.nextLine();
    }
    public void solve() {

        String[] tmp_arr_of_str = pattern_1.split(new String(s));

        String[] tmp_arr_of_nums = pattern_2.split(new String(s));
        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(tmp_arr_of_nums));
        list.addAll(Arrays.asList(tmp_arr_of_str));
        for(String t: list)
        {
            System.out.print(t.trim()+" ");

        }

    }

}
