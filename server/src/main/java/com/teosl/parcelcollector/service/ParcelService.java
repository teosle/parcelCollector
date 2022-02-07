package com.teosl.parcelcollector.service;

import java.time.Instant;
import java.util.List;

import com.teosl.parcelcollector.domain.Parcel;
import com.teosl.parcelcollector.dto.ParcelDto;
import com.teosl.parcelcollector.repository.ParcelRepository;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {
    @Autowired
    private ParcelRepository landRepository;

    @Autowired
    private ParcelGeomService parcelGeomService;

    public Parcel save(ParcelDto parcel){
        Parcel parcelToSave = new Parcel();
        if(parcel.geom == null && parcel.geoId != null){
            Polygon tmpGeom;
            try {
                tmpGeom = this.parcelGeomService.getoGeomFromGeoId(parcel.geoId);
                parcelToSave.setGeom(tmpGeom);
                parcelToSave.setGeoId(parcel.geoId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        parcelToSave.setName(parcel.name);
        parcelToSave.setCreateDate(Instant.now());
        Parcel toReturn = this.landRepository.save(parcelToSave);
        return toReturn;
    }

    public List<ParcelDto> getParcels(){
        return this.landRepository.findAll().stream().map(ParcelDto::new).map((ParcelDto parcel) -> {
            parcel.area = this.parcelGeomService.calcArea(parcel.geom);
            return parcel;
        }).toList();
    }
}
