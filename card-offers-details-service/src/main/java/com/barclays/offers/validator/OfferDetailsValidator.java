package com.barclays.offers.validator;

import com.barclays.offers.exception.OffersInvalidRequestDataException;
import com.barclays.offers.model.OffersRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component

public class OfferDetailsValidator {

    /**
     *
     * @param offersRequest
     * @throws OffersInvalidRequestDataException
     */
    public void validateRequest(OffersRequest offersRequest) throws OffersInvalidRequestDataException {

        if( offersRequest.getClientId() == null || "".equals(offersRequest.getClientId())){

            throw new OffersInvalidRequestDataException("offsvc001","Clint id is Invalid");
        }

        if( offersRequest.getChannelId() == null || "".equals(offersRequest.getChannelId())){

            throw new OffersInvalidRequestDataException("offsvc002","Channel id is Invalid");
        }

        if( offersRequest.getCardNum() == null || "".equals(offersRequest.getCardNum()) ||
                offersRequest.getCardNum().length() < 16){

            throw new OffersInvalidRequestDataException("offsvc003","Cardnumber is Invalid");
        }

        //TODO : apply validation for all the mandatory elements
    }
}
