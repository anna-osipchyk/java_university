package com.company;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Students {
    HashMap<String, HashMap> students = new HashMap<>();
    public void read_from_file() throws Exception
    {

        String []tmp;
        FileReader f = new FileReader("java_test_karpovich/test1");
        FileReader f_new = new FileReader("java_test_karpovich/test2");
        Scanner sc = new Scanner(f);
        Scanner sc_new = new Scanner(f_new);
        while(sc.hasNextLine())
        {
            HashMap<String, String> student_data = new HashMap<>();
            tmp = sc.nextLine().split(" ");
            student_data.put("birthday", tmp[2]);
            String marks = "";
            for(int i =3; i<tmp.length;i++)
            {
                marks+= tmp[i];
                marks+=" ";
            }
            student_data.put("list_of_marks", marks);
            String name = tmp[1].toString() +" "+ tmp[0].toString();
            if (students.containsKey(name))
            {
                HashMap<String, String> tmp_data =  students.get(name);
                if (tmp_data.equals(student_data))
                {
                    continue;
                }
                else if(tmp_data.get("birthday").equals(student_data.get("birthday")))
                {
                    String tmp_marks[] = tmp_data.get("list_of_marks").split(" ");

                    String student_marks[] = student_data.get("list_of_marks").split(" ");
                    Integer sum_of_marks_tmp = 0;
                    Integer sum_of_marks_student = 0;
                    for(String string: tmp_marks)
                    {
                        Integer mark = Integer.valueOf(string);
                        sum_of_marks_tmp += mark;
                    }
                    for(String string: student_marks)
                    {
                        Integer mark = Integer.valueOf(string);
                        sum_of_marks_student += mark;
                    }
                    if (sum_of_marks_student> sum_of_marks_tmp)
                    {
                        students.put(name, student_data);
                    }

                }
                else
                {
                    name += " ";
                    students.put(name, student_data);
                }

            }
            else {
                students.put(name, student_data);
            }

        }


        while(sc_new.hasNextLine())
        {
            HashMap<String, String> student_data_new = new HashMap<>();
            tmp = sc_new.nextLine().split(" ");
            student_data_new.put("birthday", tmp[2]);
            String marks = "";
            for(int i =3; i<tmp.length;i++)
            {
                marks+= tmp[i];
                marks+=" ";
            }
            student_data_new.put("list_of_marks", marks);
            String name = tmp[1].toString() +" "+ tmp[0].toString();
            if (students.containsKey(name))
            {
                HashMap<String, String> tmp_data =  students.get(name);
                if (tmp_data.equals(student_data_new))
                {
                    continue;
                }
                else if(tmp_data.get("birthday").equals(student_data_new.get("birthday")))
                {
                    String tmp_marks[] = tmp_data.get("list_of_marks").split(" ");

                    String student_marks[] = student_data_new.get("list_of_marks").split(" ");
                    Integer sum_of_marks_tmp = 0;
                    Integer sum_of_marks_student = 0;
                    for(String string: tmp_marks)
                    {
                        Integer mark = Integer.valueOf(string);
                        sum_of_marks_tmp += mark;
                    }
                    for(String string: student_marks)
                    {
                        Integer mark = Integer.valueOf(string);
                        sum_of_marks_student += mark;
                    }
                    if (sum_of_marks_student> sum_of_marks_tmp)
                    {
                        students.put(name, student_data_new);
                    }

                }
                else
                {
                    name += " ";
                    students.put(name, student_data_new);
                }

            }
            else {
                students.put(name, student_data_new);
            }

        }

       System.out.println(students.entrySet());
    }
    public void validation()
    {
        Set <String> set = students.keySet();
        ArrayList<String> ss = new ArrayList<>();
        for(String s: set)
        {
            ss.add(s);
        }

        for(int i=0; i<ss.size();i++)
        {
            String marks[] = students.get(ss.get(i)).get("list_of_marks").toString().split(" ");
            for(String mark: marks)
            {
                try
                {
                    Integer mark_int = Integer.valueOf(mark);
                    if (mark_int<0 || mark_int> 10)
                    {
                        students.remove(ss.get(i));
                        ss.remove(i);

                        break;

                    }
                }
            catch (NumberFormatException e)
            {
                students.remove(ss.get(i));
                ss.remove(i);

                break;
            }

            }

        }
        //System.out.println(students.entrySet());
    }
    public void new_file() throws Exception
    {
        File file = new File("java_test_karpovich/Res_1.txt");

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);
        Set <String> set = students.keySet();
        ArrayList<String> ss = new ArrayList<>();
        for(String s: set)
        {
            ss.add(s);
        }
        String new_stud=  "";
        for(int i=0; i<ss.size();i++) {
            new_stud+= ss.get(i);
            new_stud+=" ";
            new_stud+= students.get(ss.get(i)).get("birthday");
            new_stud+=" ";
            new_stud+= students.get(ss.get(i)).get("list_of_marks");
            new_stud+=" \n";

        }
        writer.write(new_stud);
        writer.close();
    }

    public String overall_point() throws Exception
    {
        Double point_among_all = 0.0;
        Set <String> set = students.keySet();
        ArrayList<String> ss = new ArrayList<>();
        for(String s: set)
        {
            ss.add(s);
        }

        for(int i=0; i<ss.size();i++) {
            Double sum_of_marks = 0.0;
            String marks[] = students.get(ss.get(i)).get("list_of_marks").toString().split(" ");
            for(String string: marks)
            {
                Integer mark = Integer.valueOf(string);
                sum_of_marks += mark;
            }
            Double overall_mark = sum_of_marks/4;
            String secondResult = String.format("%.3f",overall_mark);// 7,001
            students.get(ss.get(i)).put("overall_mark", secondResult);
            point_among_all+=overall_mark;

        }
        String pointResult = String.format("%.3f",point_among_all/4);// 7,001

        File file = new File("java_test_karpovich/Res_3.txt");

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);
        Set <String> set_1 = students.keySet();
        ArrayList<String> ss_1 = new ArrayList<>();
        for(String s: set)
        {
            ss_1.add(s);
        }
        String new_stud=  "";
        for(int i=0; i<ss_1.size();i++) {
            new_stud+= ss_1.get(i);
            new_stud+=" ";
            new_stud+= students.get(ss_1.get(i)).get("birthday");
            new_stud+=" ";
            new_stud+= students.get(ss_1.get(i)).get("list_of_marks");
            new_stud+=" ";
            new_stud+= students.get(ss_1.get(i)).get("overall_mark");
            new_stud+=" \n";

        }
        writer.write(new_stud);
        writer.close();


       //System.out.println(students.entrySet());
        return  pointResult;
    }
    public void sort () throws Exception
    {
        Set <String> set = students.keySet();
        ArrayList<String> ss = new ArrayList<>();
        for(String s: set)
        {
            ss.add(s);
        }
        Collections.sort(ss);
        System.out.println(ss);


        File file_1 = new File("java_test_karpovich/Res_2.txt");

        // Создание файла
        file_1.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file_1);

        String new_stud=  "";
        for(int i=0; i<ss.size();i++) {
            new_stud+= ss.get(i);
            new_stud+=" ";
            new_stud+= students.get(ss.get(i)).get("birthday");
            new_stud+=" ";
            new_stud+= students.get(ss.get(i)).get("list_of_marks");
            new_stud+=" \n";

        }
        writer.write(new_stud);
        writer.close();

    }


}
