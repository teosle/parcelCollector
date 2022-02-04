package com.teosl.parcelcollector.config.jacksonjts;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;

public class JtsDeserialize extends JsonDeserializer<Geometry>{
    GeoJsonReader reader = new GeoJsonReader();

    @Override
    public Geometry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String toParse = p.getText();
        try {
            return this.reader.read(toParse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
