package com.teosl.parcelcollector.config.jacksonjts;

import com.fasterxml.jackson.databind.module.SimpleModule;

import org.locationtech.jts.geom.*;


public class JtsModule extends SimpleModule {

    public JtsModule() {
        this(new GeometryFactory());
    }
    
    public JtsModule(GeometryFactory geometryFactory) {
        super();
        addSerializer(Geometry.class, new JtsSerialize());
        addDeserializer(Geometry.class, new JtsDeserialize());
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
    }
}