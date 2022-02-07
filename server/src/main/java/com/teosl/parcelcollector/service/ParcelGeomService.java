package com.teosl.parcelcollector.service;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
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

    public double calcArea(Geometry geometry) {
		if(geometry.isEmpty())
			return 0;
		
		Point centroid = geometry.getCentroid();
	    try {

	    	CoordinateReferenceSystem sourceCRS = CRS.decode("AUTO2:42004,"+centroid.getX()+","+centroid.getY());
			
			MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, sourceCRS);
	        Geometry projed = JTS.transform(geometry, transform);
	        return projed.getArea();
	    }catch (Exception e) {

	    	e.printStackTrace();
		}
	    return 0d;
	}
}
