package com.company;

import javax.imageio.IIOException;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TVShow extends AdvertisementsAbstract
{
    static int id = 0;
    private int index;
    private String name;
    private int channel;
    private String showtime;
    private double dollars_per_minute;
    private int max_length_of_ads;
    private int number_of_ads;
    private String host;
    public TVShow(String []arguments)
    {
        try {
            id++;
            index = id;
            name = arguments[0];
            channel = Integer.parseInt(arguments[1]);
            showtime = arguments[2];
            dollars_per_minute = Double.parseDouble(arguments[3]);
            max_length_of_ads = Integer.parseInt(arguments[4]);
            number_of_ads = Integer.parseInt(arguments[5]);
            host = arguments[6];
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong...");
        }
    }
    public TVShow(){}

    @Override
    public String toString(){
        return "Name: " + name + "\nchannel: " + channel + "\nshowtime: " + showtime +
                "\ndollars per minute: " + dollars_per_minute + "\nmax length of advertisement: " + max_length_of_ads+
                "\nnumber of pauses: "+number_of_ads+ "\nhost: "+host+"\n\n";
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getNumber_of_ads() {
        return number_of_ads;
    }

    public void setNumber_of_ads(int number_of_ads) {
        this.number_of_ads = number_of_ads;
    }

    public int getMax_length_of_ads() {
        return max_length_of_ads;
    }

    public void setMax_length_of_ads(int max_length_of_ads) {
        this.max_length_of_ads = max_length_of_ads;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public double getDollars_per_minute() {
        return dollars_per_minute;
    }

    public void setDollars_per_minute(double dollars_per_minute) {
        this.dollars_per_minute = dollars_per_minute;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        TVShow.id = id;
    }

    //    @Override
//    public String toStringForWriting(){
//        return name + ","+ channel +showtime+","+dollars_per_minute+","+max_length_of_ads+","+number_of_ads+","+host+"\n";
//    }
    public int get_index()
    {
        return index;
    }
    public void serialization_XML(String filename, XMLEncoder encoder) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println(e.toString());
            }
        });
        encoder.writeObject(this);
        encoder.close();
        fos.close();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean equals(Object o) {
        TVShow tvShow = (TVShow) o;
        return name.compareTo(tvShow.name) == 0 && channel==tvShow.channel &&
               showtime.compareTo(tvShow.showtime) == 0 && dollars_per_minute == tvShow.dollars_per_minute &&
                max_length_of_ads == tvShow.max_length_of_ads && number_of_ads == tvShow.number_of_ads &&
                host.compareTo(tvShow.host) == 0;
    }

}
//
//о передачах: название передачи, номер канала, время выхода в эфир, стоимость 1 мин рекламного времени, максимальная длительность рекламы (мин), кол-во пауз, фамилия ведущего;
//        о рекламодателях: название фирмы, рекламируемый товар;
//        о выполненных рекламных паузах: фамилия ведущего, дата, время выхода в эфир, название передачи, название фирмы, рекламируемый т