package com.barclays.offers.service;

import com.barclays.offers.builder.OffersRequestBuilder;
import com.barclays.offers.builder.OffersResponseBuilder;
import com.barclays.offers.dao.IOffersDao;
import com.barclays.offers.enrollment.svcclient.IEnrollmentServiceClient;
import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.*;
import com.barclays.offers.verify.svcclient.ICardVerifyServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OffersServiceImpl implements IOffersService {
@Autowired
    IEnrollmentServiceClient enrollmentServiceClient;
@Autowired
    ICardVerifyServiceClient cardVerifyServiceClient;
@Autowired
    IOffersDao offersDao;
@Autowired
    OffersRequestBuilder requestBuilder;
@Autowired
    OffersResponseBuilder responseBuilder;

  Logger logger = LoggerFactory.getLogger(OffersServiceImpl.class);

    @Override
    public OffersResponse getOffers(OffersRequest offersRequest) throws BusinessException, SystemException {
        OffersDaoResponse daoResp= null;

        logger.debug("Entered into getOffers() method");
       //1. Get the request from the controller

        //2. prepare the request for enrollmentReq obj
        EnrollmentRequest enrollmentRequest=requestBuilder.buildEnrollmentRequest(offersRequest);
        logger.info("enrollmentRequest"+enrollmentRequest);
        //3. call EnrollmentServiceClient by sending enrollmentRequest object and get the EnrollmentResponse
        EnrollmentResponse enrollmentResp=enrollmentServiceClient.enrollment(enrollmentRequest);
        System.out.println("Enrollmentresp from OfferServiceImpl :"+ enrollmentResp);
        //4. apply the-some business logic on enrollmentResp
        logger.info("enrollmentResponse"+enrollmentResp);


        if(enrollmentResp != null && "0".equals(enrollmentResp.getRespCode() ) && "active".equals(enrollmentResp.getStatus()) ){

            OffersDaoRequest daoReq = requestBuilder.buildDaoRequest(offersRequest);
            daoResp =offersDao.getOffers(daoReq);


        }

        //5. prepare the RequestBuilder object for cardVerify request object
       CardVerifyRequest cardVerifyReq = requestBuilder.buildCardVerifyReq(offersRequest);
       //6.call cardVerifyServiceClient by sending cardVerifyreq and get the cardVerify response
       CardVerifyResponse cardVerifyResp = cardVerifyServiceClient.cardVerify(cardVerifyReq);
       //7. apply business logic on card verify response

        //8. prepare the request for dao object, convert offersRequest to daoRequest

      //9. call dao by sending offersDaoReq and get the daoResponse

        //10. apply business logic on dao response

        //11.prepare the offersResponse
      OffersResponse offersResp = responseBuilder.buildOffersResp(daoResp, cardVerifyResp, enrollmentResp );


      logger.debug("Exit from getOffers() method");

        return offersResp;
    }
}
