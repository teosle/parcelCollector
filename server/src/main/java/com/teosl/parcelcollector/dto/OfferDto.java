package com.teosl.parcelcollector.dto;

import java.time.Instant;
import com.teosl.parcelcollector.domain.Offer;

public class OfferDto {
    public String name;
    public String description;
    public String contact;
    public String url;
    public Instant createDate;

    public OfferDto(){}

    public OfferDto( Offer offer){
        this.name = offer.getName();
        this.description = offer.getDescription();
        this.contact = offer.getContact();
        this.url = offer.getUrl();
        this.createDate = offer.getCreateDate();
    }
}
