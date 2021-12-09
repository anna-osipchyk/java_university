package com.company;

public class CommercialBreak {
    private Advertiser advertiser = new Advertiser();
    private TVShow tvShow = new TVShow();
    public CommercialBreak(Advertiser advertiser, TVShow tvShow)
    {
        this.advertiser = advertiser;
        this.tvShow = tvShow;
    }
    public String advertiser_data()
    {
        return advertiser.toString();
    }
    public String tvShow_data()
    {
        return tvShow.toString();
    }


}
