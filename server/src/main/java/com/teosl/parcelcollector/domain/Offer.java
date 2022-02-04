package com.teosl.parcelcollector.domain;

import java.time.Instant;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

@Entity
@Table(name = "offer")
public class Offer {
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "contact")
    @Getter
    @Setter
    private String contact;

    @Column(name = "url")
    @Getter
    @Setter
    private String url;

    @Column(name = "create_date")
    @Getter
    @Setter
    private Instant createDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="parcel_id")
    private Parcel parcel;
}
