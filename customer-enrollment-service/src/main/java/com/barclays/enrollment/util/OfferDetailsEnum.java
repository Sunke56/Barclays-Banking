package com.barclays.enrollment.util;

public enum OfferDetailsEnum {
    CLIENT_ID_100("100","Client Id Invalid", OfferDetailsConstant.DATA_ERROR),
    CHANNEL_ID_101("101","Channel Id Invalid",OfferDetailsConstant.DATA_ERROR),
    CARD_NUM_102("102","Card Number Invalid",OfferDetailsConstant.DATA_ERROR),
    NO_OFFERS_FOUND_103("103","Client Id Invalid",OfferDetailsConstant.DATA_ERROR),
    DB_TIMEOUT_111("111","DATABASE TIMEOUT",OfferDetailsConstant.SYSTEM_ERROR),
    DB_DOWN_112("112","DATABASE CONNECTION FAILURE",OfferDetailsConstant.SYSTEM_ERROR),
    DB_SYNTAX_113("113","DATABASE SYNTAX ERROR",OfferDetailsConstant.SYSTEM_ERROR);

    private String errorCode;
    private String errorMsg;
    private String typeOfError;

    OfferDetailsEnum(String errorCode, String errorMsg, String typeOfError) {

        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.typeOfError = typeOfError;
    }

    public static boolean checkErrorCode(String errorCode,String typeOfError) {

        boolean flag = false;
        for(OfferDetailsEnum offerEnum : OfferDetailsEnum.values()) {

            if((errorCode.equals(offerEnum.errorCode) && typeOfError.equals(offerEnum.typeOfError)) ){
               flag = true;
            }
        }
        return false;
    }
}
