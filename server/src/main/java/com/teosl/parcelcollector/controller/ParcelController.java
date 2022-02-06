package com.teosl.parcelcollector.controller;

import java.util.List;

import com.teosl.parcelcollector.domain.Parcel;
import com.teosl.parcelcollector.dto.ParcelDto;
import com.teosl.parcelcollector.service.ParcelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//for test
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/parcel")
public class ParcelController {
    @Autowired
    ParcelService landService;

    @GetMapping(path="/")
    public List<ParcelDto> getAllParcel(){
        return this.landService.getParcels();
    }

    @PostMapping(path ="/")
    public Parcel createLand(@RequestBody ParcelDto parcel) {
        return landService.save(parcel);
    }
}