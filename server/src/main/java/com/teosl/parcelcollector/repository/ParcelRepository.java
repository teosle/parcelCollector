package com.teosl.parcelcollector.repository;

import com.teosl.parcelcollector.domain.Parcel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long>{
    
}