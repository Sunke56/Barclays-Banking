package com.barclays.offers.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String respCode;
    private String respMsg;

    public SystemException(String respCode, String respMsg) {

        this.respCode = respCode;
        this.respMsg = respMsg;

    }
}