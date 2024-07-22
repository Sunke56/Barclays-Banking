package com.barclays.offers.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonSerializationDemo {
    public static void main(String[] args) throws JsonProcessingException {
        OffersResponse offersResponse=new OffersResponse();
        StatusBlock statusBlock=new StatusBlock();
        statusBlock.setRespCode("0");
        statusBlock.setRespMsg("success");

        List<OfferDetails> offerList=new ArrayList<OfferDetails>();

        OfferDetails offers1=new OfferDetails();
        offers1.setDate("02-04-24");
        offers1.setDesc("Good");
        offers1.setName("apple 15x");
        offers1.setImageUrl("http://s3.amazon.com:8080/apple.png");
        offers1.setOfferId("17171");
        offers1.setStatus("active");

        OfferDetails offers2=new OfferDetails();
        offers2.setDate("02-04-24");
        offers2.setDesc("Good");
        offers2.setName("apple 15x");
        offers2.setImageUrl("http://s3.amazon.com:8080/apple.png");
        offers2.setOfferId("17171");
        offers2.setStatus("active");

        OfferDetails offers3=new OfferDetails();
        offers3.setDate("02-04-24");
        offers3.setDesc("Good");
        offers3.setName("apple 15x");
        offers3.setImageUrl("http://s3.amazon.com:8080/apple.png");
        offers3.setOfferId("17171");
        offers3.setStatus("active");

        offerList.add(offers1);
        offerList.add(offers2);
        offerList.add(offers3);


        offersResponse.setStatusBlock(statusBlock);
        offersResponse.setOffers(offerList);

        ObjectMapper objectMapper=new ObjectMapper();

        String jsonData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(offersResponse);

    }
}
