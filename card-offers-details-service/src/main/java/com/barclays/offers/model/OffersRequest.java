package com.barclays.offers.model;

import lombok.Data;

@Data
public class OffersRequest {

    private String cardNum;
    private String clientId;
    private String channelId;
    private String msgTs;
    private String correlationId;
    private String authToken;
}
