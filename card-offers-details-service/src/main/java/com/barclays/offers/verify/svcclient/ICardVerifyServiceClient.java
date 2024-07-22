package com.barclays.offers.verify.svcclient;

import com.barclays.offers.model.CardVerifyRequest;
import com.barclays.offers.model.CardVerifyResponse;

public interface ICardVerifyServiceClient {
    CardVerifyResponse cardVerify(CardVerifyRequest cardVerifyRequest);
}
