package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class Main {
        public static void main(String[] args) throws Exception{
            ArrayList<String[]> tmp = new ArrayList<>();
            ArrayList<String> bugs_for_output = new ArrayList<>();
            HashMap<Integer, String[]> bugs =  new HashMap<>();
            HashMap<String,String> qa = new HashMap<>();
            HashMap<String, String> pr = new HashMap<>();
            String priority;
            FileReader fr = new FileReader("input5.txt");
            Scanner sc = new Scanner(fr);
            priority = sc.nextLine();
            sc.close();
            FileReader fr1 = new FileReader("input1.txt");
            Scanner sc1 = new Scanner(fr1);
            while(sc1.hasNextLine())
            {
                String[] data;
                data = sc1.nextLine().split(";");
                bugs_for_output.add(data[3]);
                tmp.add(data);
                bugs.put(Integer.parseInt(data[0]), data);
            }
            FileReader fr2 = new FileReader("input4.txt");
            Scanner sc2 = new Scanner(fr2);
            while(sc2.hasNextLine()){
                String data[];
                data = sc2.nextLine().split(";");
                pr.put(data[0], data[1]);
            }
            ArrayList<String[]> copy_of_tmp  = new ArrayList<>();
            FileReader fr5 = new FileReader("input1.txt");
            Scanner sc5 = new Scanner(fr5);
            while(sc5.hasNextLine()) {
                String[] data;
                data = sc5.nextLine().split(";");

                copy_of_tmp.add(data);
            }
            String str = "";
            for(int i =0; i< tmp.size();i++)
            {
                for(String kay: pr.keySet())
                {
                    if (kay.equals(tmp.get(i)[3]))
                    {
                        tmp.get(i)[3] = pr.get(kay);
                    }
                }
            }
            task_1(priority,tmp);
            FileReader fr4 = new FileReader("input6.txt");
            Scanner sc4 = new Scanner(fr4);
            String qa_id = sc4.nextLine();
            FileReader fr3 = new FileReader("input3.txt");
            Scanner sc3 = new Scanner(fr3);
            FileWriter fw = new FileWriter("output3.txt");
            String sstr = "";
            while(sc3.hasNextLine()){
                String data[];
                data = sc3.nextLine().split(";");
                String bug_id = data[0];
                qa.put(bug_id, data[1]);
                String qa_id_tmp = data[1];
                if(qa_id_tmp.equals(qa_id))
                {
                    for (String []s: tmp)
                        if (bug_id.equals(s[0]))
                        {
                            sstr+=s[2]+"\n";
                        }
                }

            }
            fw.write(sstr.strip());
            fw.close();
            String s = "";
            FileWriter fw1 = new FileWriter("output2.txt");
            // Collections.sort(…)
            List<String []> list = new ArrayList<String []>();
            Collections.sort(copy_of_tmp, new Comparator<String[]>() {
                public int compare(String[] o1, String[] o2) {
                    return o1[3].toString().compareTo(o2[3].toString());
                }
            });
            String s1 = "";
            for(String str1[]: copy_of_tmp)
            {
                s1+=str1[2]+";";
                s1+=pr.get(str1[3])+"\n";
            }
            fw1.write(s1.strip());
            fw1.close();
            String str2 = "";
            ArrayList<String []> tmp2 = new ArrayList<>();
            for(String[]s2: tmp)
            {
                s2[0] = qa.get(s2[0]);
                if(s2[0].equals(qa_id))
                {
                    tmp2.add(s2);
                }
            }
            Collections.sort(tmp2, new Comparator<String[]>() {
                public int compare(String[] o1, String[] o2) {
                    return o1[4].toString().compareTo(o2[4].toString());
                }
            });
            String str3 ="";
            for(int i=tmp2.size()-1; i>=0;i--)
            {
                str3+=tmp2.get(i)[2]+";"+tmp2.get(i)[4]+"\n";
            }
            FileWriter fw3 = new FileWriter("output4.txt");
            fw3.write(str3.strip());
            fw3.close();
        }
        public static void task_1(String priority,  ArrayList<String[]> tmp) throws Exception{
            int flag = 0;
            String str1="";
            FileWriter fr = new FileWriter("output1.txt");
            for (String str []: tmp)
            {
                if (priority.equals(str[3]))
                {
                    str1+=str[2]+"\n";

                }
            }
            fr.write(str1.strip()); fr.close();
        }
    }





