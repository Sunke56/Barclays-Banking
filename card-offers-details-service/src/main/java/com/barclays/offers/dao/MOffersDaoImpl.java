package com.barclays.offers.dao;

import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OffersDaoRequest;
import com.barclays.offers.model.OffersDaoResponse;
import com.barclays.offers.model.OffersDetailsDao;
import com.barclays.offers.util.OfferDetailsConstant;
import com.barclays.offers.util.OfferDetailsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MOffersDaoImpl implements IOffersDao {

    Logger logger = LoggerFactory.getLogger(MOffersDaoImpl.class);
    @Override
    public OffersDaoResponse getOffers(OffersDaoRequest daoRequest) throws BusinessException,SystemException {
        //1. Get the request from the service

        //2. prepare the request for database

        //3. call the database and get the response

        String dbRespCode="0";
        String dbRespMsg="success";

        OffersDaoResponse offersDaoResponse = new OffersDaoResponse();

        try {
            List<OffersDetailsDao> offersDaoList = new ArrayList<OffersDetailsDao>();

            if(OfferDetailsConstant.SUCCESS_RESP_CODE.equals(dbRespCode)) {


                OffersDetailsDao offersDetailsDao1 = new OffersDetailsDao();
                offersDetailsDao1.setDate("02-04-24");
                offersDetailsDao1.setDesc("Good");
                offersDetailsDao1.setName("apple 15x");
                offersDetailsDao1.setImageUrl("http://s3.amazon.com:8080/apple.png");
                offersDetailsDao1.setOfferId("17171");
                offersDetailsDao1.setStatus("active");

                OffersDetailsDao offersDetailsDao2 = new OffersDetailsDao();
                offersDetailsDao2.setDate("02-04-24");
                offersDetailsDao2.setDesc("Good");
                offersDetailsDao2.setName("apple 15x");
                offersDetailsDao2.setImageUrl("http://s3.amazon.com:8080/apple.png");
                offersDetailsDao2.setOfferId("17171");
                offersDetailsDao2.setStatus("active");

                OffersDetailsDao offersDetailsDao3 = new OffersDetailsDao();
                offersDetailsDao3.setDate("02-04-24");
                offersDetailsDao3.setDesc("Good");
                offersDetailsDao3.setName("apple 15x");
                offersDetailsDao3.setImageUrl("http://s3.amazon.com:8080/apple.png");
                offersDetailsDao3.setOfferId("17171");
                offersDetailsDao3.setStatus("active");

                offersDaoList.add(offersDetailsDao1);
                offersDaoList.add(offersDetailsDao2);
                offersDaoList.add(offersDetailsDao3);

                offersDaoResponse.setOffersDaoList(offersDaoList);
                offersDaoResponse.setRespCode(dbRespCode);
                offersDaoResponse.setRespMsg(dbRespMsg);
            }
            else if(OfferDetailsEnum.checkErrorCode(dbRespCode, OfferDetailsConstant.DATA_ERROR)){

                throw new BusinessException(dbRespCode,dbRespMsg);
            }
            else if(OfferDetailsEnum.checkErrorCode(dbRespCode, OfferDetailsConstant.SYSTEM_ERROR)){

                throw new SystemException(dbRespCode,dbRespMsg);
            }
            else{

                throw new SystemException(OfferDetailsConstant.DB_UNKNOWN_ERROR_CODE, OfferDetailsConstant.DB_UNKNOWN_ERROR_MSG);
            }
        } catch (BusinessException be) {

            logger.error("respCode :"+be.getRespCode(),be);
            throw be;

        } catch (SystemException se) {

            logger.error("respCode :"+se.getRespCode(),se);
            throw se;

        }


        return offersDaoResponse;
    }
}
