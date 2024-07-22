package com.barclays.offers.controller;

import com.barclays.offers.builder.OffersResponseBuilder;
import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.OffersInvalidRequestDataException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OffersResponse;
import com.barclays.offers.model.StatusBlock;
import com.barclays.offers.util.OfferDetailsConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class OfferDetailsControllerAdvice {
@Autowired
    OffersResponseBuilder offersResponseBuilder;
    Logger logger = LoggerFactory.getLogger( OfferDetailsControllerAdvice.class);

    @ExceptionHandler(value = OffersInvalidRequestDataException.class)
    public OffersResponse handleRequestInvalidException(OffersInvalidRequestDataException exception) {

        String errorInfo = "respCode :"+exception.getRespCode()+":"+"respMsg :"+exception.getRespMsg();
        MDC.put("errorInfo", errorInfo);

      return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());

    }


    @ExceptionHandler(value = BusinessException.class)
    public OffersResponse handleRequestInvalidException(BusinessException exception) {

        String errorInfo = "respCode :"+exception.getRespCode()+":"+"respMsg :"+exception.getRespMsg();
        MDC.put("errorInfo", errorInfo);
        logger.error("errorInfo is :"+errorInfo);

        return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());
    }

    @ExceptionHandler(value = SystemException.class)
    public OffersResponse handleRequestInvalidException(SystemException exception) {

        String errorInfo = "respCode :"+exception.getRespCode()+":"+"respMsg :"+exception.getRespMsg();
        MDC.put("errorInfo", errorInfo);
        logger.error("errorInfo is :"+errorInfo);

        return offersResponseBuilder.buildOffersResp(exception.getRespCode(), exception.getRespMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public OffersResponse handleRequestInvalidException(Exception exception) {

        String errorInfo = "respCode :"+OfferDetailsConstant.GENERIC_ERROR_CODE+ ":"+"respMsg :"+OfferDetailsConstant.GENERIC_ERROR_MSG;
        MDC.put("errorInfo", errorInfo);
        logger.error("errorInfo is :"+errorInfo);

        return offersResponseBuilder.buildOffersResp(OfferDetailsConstant.GENERIC_ERROR_CODE, OfferDetailsConstant.GENERIC_ERROR_MSG);
    }

}