package com.company;

import java.io.*;
import java.util.*;

public class Advertisements implements AdvertisementsInterface {
    static final String path_1 = "tvShow";
    static final String path_2 = "advertiser";
    private HashMap<Integer, Advertiser> advertiser = new HashMap<>();
    private HashMap<Integer, TVShow> tvShow = new HashMap<>();

    public Advertisements() throws IOException {
        read(path_1, path_2);
    }

    @Override
    public void read(String path_1, String path_2) throws IOException {
        FileReader fr_tvShow = new FileReader(path_1);
        Scanner scanner = new Scanner(fr_tvShow);
//        FileReader fr_commercialBreak = new FileReader("commercialBreak.txt");
        FileReader fr_advertiser = new FileReader(path_2);
        while (scanner.hasNextLine()) {
            String data_for_object = scanner.nextLine();
            String args[] = data_for_object.split(",");
            TVShow tvShow_obj = new TVShow(args);
            tvShow.putIfAbsent(tvShow_obj.get_index(), tvShow_obj);

        }
        scanner = new Scanner(fr_advertiser);
        while (scanner.hasNextLine()) {
            String data_for_object = scanner.nextLine();
            String args[] = data_for_object.split(",");
            Advertiser ads = new Advertiser(args);
            advertiser.putIfAbsent(ads.get_index(), ads);

        }
        fr_advertiser.close();
        fr_tvShow.close();
    }


    @Override
    public void write(String path_1, String path_2) throws IOException {
        FileWriter fw_1 = new FileWriter(path_1);
        FileWriter fw_2 = new FileWriter(path_2);
        for (TVShow value : tvShow.values()) {
            fw_1.write(value.toString());
        }
        for (Advertiser value : advertiser.values()) {
            fw_2.write(value.toString());
        }
        fw_1.close();
        fw_2.close();
    }

    @Override
    public void serialization() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("project.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    @Override
    public void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("project.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Advertisements tmp = (Advertisements) objectInputStream.readObject();
        advertiser = tmp.advertiser;
        tvShow = tmp.tvShow;
        objectInputStream.close();
    }

    @Override
    public void search() {
        System.out.println("Please, enter data following the next order: firm name, product\nNote: don't use any extra spaces\n");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        ArrayList<String> arrayList_for_ads = new ArrayList<>(Arrays.asList(data.split(",")));
        Advertiser tmp_ads = new Advertiser(arrayList_for_ads.toArray(new String[0]));
        boolean flag = false;
        System.out.println("And one more time: name, channel, showtime, dollars_per_minute, max_length_of_ads, number_of_ads, host\nNote: don't use any extra spaces\n");
        data = sc.nextLine();
        ArrayList<String> arrayList_for_tv = new ArrayList<>(Arrays.asList(data.split(",")));
        TVShow tmp_tv = new TVShow(arrayList_for_tv.toArray(new String[0]));
        for (Advertiser value_1 : advertiser.values()) {
            for (TVShow value_2 : tvShow.values()) {
                if (tmp_ads.equals(value_1) && tmp_tv.equals(value_2)) {
                    flag = true;
                    System.out.println("Look, what i found:\n" + value_2 + value_1);
                }

            }
        }
        if (!flag) {
            System.out.println("Didn't find anything");
        }
        sc.close();
    }

    @Override
    public void add(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: firm name, product\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Advertiser tmp = new Advertiser(data.split(","));
                if (!advertiser.containsValue(tmp)) {
                    advertiser.put(tmp.get_index(), tmp);
                    System.out.println("Added successfully!");
                } else System.out.println("Wrong input or advertiser already exists!");
            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: name, channel, showtime, dollars_per_minute, max_length_of_ads, number_of_ads, host\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                TVShow tmp = new TVShow(data.split(","));
                if (!tvShow.containsValue(tmp)) {
                    tvShow.put(tmp.get_index(), tmp);
                    System.out.println("Added successfully!");
                } else System.out.println("Wrong input or tv show already exists!");
            }
        }
    }

    @Override
    public void delete(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: firm name, product\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Advertiser tmp = new Advertiser(data.split(","));
                ArrayList<Integer> list_ok_keys = new ArrayList<>();
                if (!advertiser.containsValue(tmp)) {
                    System.out.println("The object is not in the map!");
                } else {
                    for (Integer key : advertiser.keySet()) {
                        if (advertiser.get(key).equals(tmp)) {
                            list_ok_keys.add(key);
                        }
                    }
                }
                    for (Integer key: list_ok_keys) {
                        advertiser.remove(key);
                    }
                    System.out.println("Removed successfully!");

            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: name, channel, showtime, dollars_per_minute, max_length_of_ads, number_of_ads, host\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                TVShow tmp = new TVShow(data.split(","));
                ArrayList<Integer> list_ok_keys = new ArrayList<>();
                if (!tvShow.containsValue(tmp)) {
                    System.out.println("Object is not in the map!");
                } else {
                    for (Integer key : tvShow.keySet()) {
                        if (tvShow.get(key).equals(tmp)) {
                            list_ok_keys.add(key);
                        }
                    }

                        for (Integer key: list_ok_keys) {
                            tvShow.remove(key);
                        }
                        System.out.println("Removed successfully!");
                    }


            }
        }
    }

    public void show() {
        System.out.println("Advertisers: ");
        for (Advertiser value : advertiser.values()) {

            System.out.println(value);
        }
        System.out.println("Tv shows: ");
        for (TVShow value : tvShow.values()) {

            System.out.println(value);
        }

    }

    @Override
    public void update(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: firm name, product\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Advertiser tmp = new Advertiser(data.split(","));
                if (!advertiser.containsValue(tmp)) {
                    System.out.println("The object is not in the map!");
                } else {
                    ArrayList<Integer> list_of_keys = new ArrayList<>();
                    for (Integer key : advertiser.keySet()) {
                        if (advertiser.get(key).equals(tmp)) {
                            list_of_keys.add(key);
                        }
                    }
                    System.out.println("Please, enter data following the next order: firm name, product\nNote: don't use any extra spaces\n");
                    data = sc.nextLine();

                    for (Integer key : list_of_keys) {
                        advertiser.remove(key);
                        Advertiser updated_tmp = new Advertiser(data.split(","));
                        advertiser.put(updated_tmp.get_index(), updated_tmp);
                    }
                    System.out.println("Updated successfully!");
                }
            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: name, channel, showtime, dollars_per_minute, max_length_of_ads, number_of_ads, host\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                TVShow tmp = new TVShow(data.split(","));
                if (!tvShow.containsValue(tmp)) {
                    System.out.println("Object is not in the map!");
                } else {
                    ArrayList<Integer> list_of_keys = new ArrayList<>();
                    for (Integer key : tvShow.keySet()) {
                        if (tvShow.get(key).equals(tmp)) {
                            list_of_keys.add(key);
                        }
                    }
                    System.out.println("Please, enter data following the next order: name, channel, showtime, dollars_per_minute, max_length_of_ads, number_of_ads, host\nNote: don't use any extra spaces\n");
                    data = sc.nextLine();

                    for (Integer key : list_of_keys) {
                        tvShow.remove(key);
                        TVShow updated_tmp = new TVShow(data.split(","));
                        tvShow.put(updated_tmp.get_index(), updated_tmp);
                    }
                    System.out.println("Updated successfully!");
                }
            }
        }

    }

    public void show_menu(int param) {
        switch (param) {
            case (1) -> System.out.println("""
                    To add advertiser press 1\s
                    To delete advertiser press 2\s
                    To update advertiser press 3\s
                    To go to main menu press 0\s
                    """);
            case (2) -> System.out.println("""
                    To add tv show press 1\s
                    To delete tv show press 2\s
                    To update tv show press 3\s
                    To go to main menu press 0\s
                    """);
            case (3) -> System.out.println(
                    """
                            To search commercial break press 1\s
                            To go to main menu press 0\s
                            """);
            default -> System.out.println("""
                    To work with advertisers press 1\s
                    To work with tw shows press 2\s
                    To work with commercial breaks press 3\s
                    To show current maps press 4\s
                    To exit press 0\s
                    """);
        }
    }

    public void menu() throws IOException {
        show_menu(0);
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch (Integer.parseInt(command)) {
            case (0) -> {
                write("tvShow_output", "advertisers_output");
                serialization();
                System.exit(0);
            }
            case (1) -> {
                show_menu(1);
                Scanner sc1 = new Scanner(System.in);
                String command1 = sc1.next();
                switch (Integer.parseInt(command1)) {
                    case (0) -> menu();
                    case (1) -> {
                        add(1);
                        menu();
                    }
                    case (2) -> {
                        delete(1);
                        menu();
                    }
                    case (3) -> {
                        update(1);
                        menu();
                    }

                }
            }
            case (2) -> {
                show_menu(2);
                Scanner sc2 = new Scanner(System.in);
                String command2 = sc2.next();
                switch (Integer.parseInt(command2)) {
                    case (0) -> menu();
                    case (1) -> {
                        add(2);
                        menu();
                    }
                    case (2) -> {
                        delete(2);
                        menu();
                    }
                    case (3) -> {
                        update(2);
                        menu();
                    }

                }
            }
            case (3) -> {
                show_menu(3);
                Scanner sc3 = new Scanner(System.in);
                String command3 = sc3.next();
                switch (Integer.parseInt(command3)) {
                    case (0) -> menu();
                    case (1) -> {
                        search();
                        menu();
                    }
                }
            }
            case (4) -> {
                show();
                menu();

            }
        }
    }
}




