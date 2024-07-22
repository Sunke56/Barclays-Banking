package com.barclays.offers.dao;

import com.barclays.offers.model.OffersDaoRequest;
import com.barclays.offers.model.OffersDaoResponse;

public interface IOffersDao {
     OffersDaoResponse getOffers(OffersDaoRequest daoRequest);
}
