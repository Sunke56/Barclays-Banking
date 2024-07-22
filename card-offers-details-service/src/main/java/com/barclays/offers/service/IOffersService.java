package com.barclays.offers.service;

import com.barclays.offers.model.OffersRequest;
import com.barclays.offers.model.OffersResponse;

public interface IOffersService {

   OffersResponse getOffers(OffersRequest offersRequest);
}
