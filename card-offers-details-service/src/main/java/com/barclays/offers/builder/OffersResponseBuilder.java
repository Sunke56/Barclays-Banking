package com.barclays.offers.builder;

import com.barclays.offers.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffersResponseBuilder {

    /**
     *Description : Prepare the OffersResponse with the help of daoResp
     * @param daoResp
     * @param cardVerifyResp
     * @param enrollmentResp
     * @return
     */
    public OffersResponse buildOffersResp(OffersDaoResponse daoResp, CardVerifyResponse cardVerifyResp, EnrollmentResponse enrollmentResp) {

        OffersResponse offersResponse = new OffersResponse();

        List<OfferDetails> offersList = new ArrayList<OfferDetails>();

        // get the list of offers from dao and prepare the service offers object

        for(OffersDetailsDao offerDaoDtls : daoResp.getOffersDaoList() ) {

            OfferDetails offerDetails = new OfferDetails();

            offerDetails.setDate(offerDaoDtls.getDate());
            offerDetails.setDesc(offerDaoDtls.getDesc());
            offerDetails.setImageUrl(offerDaoDtls.getImageUrl());
            offerDetails.setName(offerDaoDtls.getName());
            offerDetails.setOfferId(offerDaoDtls.getOfferId());
            offerDetails.setStatus(offerDaoDtls.getStatus());

            offersList.add(offerDetails);
        }

        StatusBlock statusBlock = new StatusBlock();
        statusBlock.setRespCode(daoResp.getRespCode());
        statusBlock.setRespMsg(daoResp.getRespMsg());
        offersResponse.setStatusBlock(statusBlock);
        offersResponse.setOffers(offersList);

        offersResponse.setOffers(offersList);

        return offersResponse;
    }
    public OffersResponse buildOffersResp(String respCode, String respMsg) {

        OffersResponse offersResponse = new OffersResponse();

        StatusBlock statusBlock = new StatusBlock();
        statusBlock.setRespCode(respCode);
        statusBlock.setRespMsg(respMsg);

        offersResponse.setStatusBlock(statusBlock);

        return offersResponse;
    }
}
