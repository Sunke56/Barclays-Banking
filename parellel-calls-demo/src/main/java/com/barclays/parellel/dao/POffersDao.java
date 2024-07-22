package com.barclays.parellel.dao;

import com.barclays.parellel.model.Offers;

public class POffersDao {

    public Offers getOffers(String CardNum){

        Offers offers1 = new Offers();

        offers1.setId("111");
        offers1.setName("mobile");
        offers1.setDesc("good");
        offers1.setImageUrl("http://amazon/mobile");
        offers1.setExpDate("20-May-2024");

        return offers1;


    }
}
