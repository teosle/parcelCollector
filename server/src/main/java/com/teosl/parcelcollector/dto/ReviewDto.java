package com.teosl.parcelcollector.dto;

import com.teosl.parcelcollector.domain.Review;

public class ReviewDto {
    public double raiting;

    public ReviewDto(){}

    public ReviewDto( Review review){
        this.raiting = review.getRaiting();
    }
}
