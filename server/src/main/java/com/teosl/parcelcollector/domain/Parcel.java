package com.teosl.parcelcollector.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.locationtech.jts.geom.Polygon;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parcel")
public class Parcel implements Serializable{
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Getter
    @Id
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "geom")
    @Getter
    @Setter
    private Polygon geom;
     
    @Column(name = "geo_id")
    @Getter
    @Setter
    private String geoId;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;
    
    @Column(name = "create_date")
    @Getter
    @Setter
    private Instant createDate;
    
    @OneToMany(mappedBy="parcel")
    @Getter
    @Setter
    private List<Offer> offers;

    @OneToMany(mappedBy="parcel")
    @Getter
    @Setter
    private List<Review> reviews;
}
