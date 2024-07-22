package com.barclays.offers.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OffersResponse {

    private List<OfferDetails> offers;
    private StatusBlock statusBlock;

}
