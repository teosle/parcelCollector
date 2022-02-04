package com.teosl.parcelcollector.service;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParcelGeomService {
    static private int srid = 4326;
    RestTemplate restTemplate = new RestTemplate();
    //http://uldk.gugik.gov.pl/opis.html#
    String geomBaseUrl = "https://uldk.gugik.gov.pl/?request=GetParcelById&srid="+srid+"&id=";
    // GeometryFactory fact = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 2180);
    GeometryFactory fact = new GeometryFactory();
    WKBReader wkbRdr = new WKBReader(fact);
    
    public Polygon getoGeomFromGeoId(String geoId) throws ParseException{
       try {
        String url = geomBaseUrl + geoId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String WKBToParse = response.getBody().substring(2).toLowerCase().replaceAll("[^0-9a-z]", "");
        byte[] wKBytes = WKBReader.hexToBytes(WKBToParse);
        return  (Polygon) wkbRdr.read(wKBytes); 
       } catch (Exception e) {
           //TODO: handle exception
           throw e;
       }
    }
}
