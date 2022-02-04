package com.teosl.parcelcollector.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

@Entity
@Table(name = "review")
public class Review {
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "raiting")
    @Getter
    @Setter
    private double raiting;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="parcel_id")
    private Parcel parcel;
}
