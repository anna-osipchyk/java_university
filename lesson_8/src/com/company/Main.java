package com.company;

public class Main {

    public static void main(String[] args) {
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
            ads.menu();

        }
        catch (Exception ex)
        {

        }
    }
}
