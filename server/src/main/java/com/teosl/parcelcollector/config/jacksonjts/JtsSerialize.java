package com.teosl.parcelcollector.config.jacksonjts;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.geojson.GeoJsonWriter;

public class JtsSerialize extends JsonSerializer<Geometry>{
    GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
    
    @Override
    public void serialize(Geometry value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String geoJson = geoJsonWriter.write(value);
        gen.writeRawValue(geoJson);   
    }
    
}
