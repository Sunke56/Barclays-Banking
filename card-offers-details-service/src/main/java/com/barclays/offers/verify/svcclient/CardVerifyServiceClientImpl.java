package com.barclays.offers.verify.svcclient;

import com.barclays.offers.model.CardVerifyRequest;
import com.barclays.offers.model.CardVerifyResponse;
import org.springframework.stereotype.Component;

@Component
public class CardVerifyServiceClientImpl implements ICardVerifyServiceClient {
    @Override
    public CardVerifyResponse cardVerify(CardVerifyRequest cardVerifyRequest) {
        return null;
    }
}
