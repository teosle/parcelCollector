package com.teosl.parcelcollector.dto;

import java.time.Instant;
import java.util.List;
import com.teosl.parcelcollector.domain.*;
import org.locationtech.jts.geom.Geometry;

public class ParcelDto {
    public Long id;
    public String name;
    public String description;
    public String geoId;
    public Geometry geom;
    public double area;
    public Instant createDate;
    public List<OfferDto> offers;
    public List<ReviewDto> reviews;

    public ParcelDto(){}

    public ParcelDto(Parcel parcel){
        this.id = parcel.getId();
        this.name = parcel.getName();
        this.description = parcel.getDescription();
        this.geoId = parcel.getGeoId();
        this.geom = parcel.getGeom();
        this.area = parcel.getGeom().getArea();
        this.createDate = parcel.getCreateDate();
        this.offers = parcel.getOffers().stream().map(OfferDto::new).toList();
        this.reviews = parcel.getReviews().stream().map(ReviewDto::new).toList();
    }
}
