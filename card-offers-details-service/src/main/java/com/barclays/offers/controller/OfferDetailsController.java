package com.barclays.offers.controller;

import com.barclays.offers.exception.OffersInvalidRequestDataException;
import com.barclays.offers.model.OffersRequest;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.service.IOffersService;
import com.barclays.offers.util.OfferDetailsConstant;
import com.barclays.offers.validator.OfferDetailsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class OfferDetailsController {
    @Autowired
    OfferDetailsValidator offerDetailsValidator;
    @Autowired
    IOffersService offersService;

    Logger logger = LoggerFactory.getLogger(OfferDetailsController.class);

    /**
     *
     * @param cardNum
     * @param clientId
     * @param channelId
     * @param msgTs
     * @param correlationId
     * @param authToken
     * @return
     * @throws OffersInvalidRequestDataException
     */

@GetMapping("/offers/{cardNumber}")
       OffersResponse getOffers( @PathVariable(OfferDetailsConstant.CARD_NUM) String cardNum,
                                 @RequestHeader(name = OfferDetailsConstant.CLIENT_ID, required = false) String clientId,
                                 @RequestHeader(name = OfferDetailsConstant.CHANNEL_ID, required = false) String channelId,
                                 @RequestHeader(name = OfferDetailsConstant.MSG_TS, required = false) String msgTs,
                                 @RequestHeader(name = OfferDetailsConstant.CORRELATION_ID, required = false) String correlationId,
                                 @RequestHeader(name = OfferDetailsConstant.AUTH_TOKEN, required = false) String authToken ) throws OffersInvalidRequestDataException {

      logger.debug("Entered into getOffers method");

    MDC.put("clientId","clientId");
    MDC.put("cardNumber",cardNum.substring(11,16));
    MDC.put("channelId","channelId");
    MDC.put("correlationId","correlationId");



      OffersRequest offersRequest=new OffersRequest();
      offersRequest.setCardNum(cardNum);
      offersRequest.setClientId(clientId);
      offersRequest.setChannelId(channelId);
      offersRequest.setMsgTs(msgTs);
      offersRequest.setCorrelationId(correlationId);
      offersRequest.setAuthToken(authToken);


        //1.validate the request
       offerDetailsValidator.validateRequest(offersRequest);
        //2.prepare the request for service layer
       //3.call the service layer and get the response
        OffersResponse offersResponse=offersService.getOffers(offersRequest);

        logger.info("offerResponse :"+offersResponse);

        logger.debug("Exit from getOffers method");

        return offersResponse;

    }
}
