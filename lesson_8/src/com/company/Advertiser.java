package com.company;

public class Advertiser extends AdvertisementsAbstract {
    //о рекламодателях: название фирмы, рекламируемый товар;
    static int id = 0;
    private int index;
    private String firm_name;
    private String product;
    public Advertiser(String []arguments)
    {
        try
        {
            id++;
            index = id;
            firm_name = arguments[0];
            product = arguments[1];
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong");
        }
    }
    public Advertiser(){}
    @Override
    public String toString(){
        return "Firm name: " + firm_name + "\nproduct: " + product+"\n\n";
    }
    @Override
    public String toStringForWriting(){
        return firm_name + ","+ product+"\n";
    }
    public int get_index()
    {
        return index;
    }
    public boolean equals(Object o) {
        Advertiser advertiser = (Advertiser) o;
        return firm_name.compareTo(advertiser.firm_name) == 0 &&
                product.compareTo(advertiser.product) == 0;
    }

}
