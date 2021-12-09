package com.company;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        String[] arguments_1 = {"Love for hearts", "1", "12:30","2","1","3", "Legend Legendarovich"};
//        TVShow tvshow = new TVShow(arguments_1);
////        System.out.println(tvshow);
//        String[] arguments_2 = {"Itechart", "Developers"};
//        Advertiser advertiser = new Advertiser(arguments_2);
////        System.out.println(advertiser);
//        CommercialBreak commercialBreak = new CommercialBreak(advertiser, tvshow);
//        System.out.println(commercialBreak.advertiser_data());
//        System.out.println(commercialBreak.tvShow_data());
        try {
            Advertisements ads = new Advertisements();
            ads.search_company_name();
            ads.menu();
        }
        catch (Exception ex)
        {

        }
    }
}
