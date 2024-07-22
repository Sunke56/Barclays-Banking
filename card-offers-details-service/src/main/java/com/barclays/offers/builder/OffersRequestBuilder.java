package com.barclays.offers.builder;

import com.barclays.offers.model.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OffersRequestBuilder {
    public EnrollmentRequest buildEnrollmentRequest(OffersRequest offersRequest) {
        //TODO : prepare the enrollmentRequest with the help of offersRequest
        EnrollmentRequest enrollmentReq = new EnrollmentRequest();
        enrollmentReq.setCardNum(offersRequest.getCardNum());
        enrollmentReq.setDate(new Date().toString());
        enrollmentReq.setName("Shiva");

        return enrollmentReq;
    }

    public CardVerifyRequest buildCardVerifyReq(OffersRequest offersRequest) {

         return null;
    }

    public OffersDaoRequest buildDaoRequest(OffersRequest offersRequest) {
        OffersDaoRequest offersDaoRequest=new OffersDaoRequest();

        offersDaoRequest.setCardNum(offersRequest.getCardNum());
        offersDaoRequest.setClientId(offersDaoRequest.getClientId());
        offersDaoRequest.setChannelId(offersDaoRequest.getChannelId());
        offersDaoRequest.setTypeOfOffers(offersDaoRequest.getTypeOfOffers());

        return null;
    }
}
