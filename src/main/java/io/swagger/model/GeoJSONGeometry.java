package io.swagger.model;

import org.brapi.test.BrAPITestServer.serializer.CustomGeoJSONDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * OneOfgeoJSONGeometry
 */
@JsonDeserialize(using = CustomGeoJSONDeserializer.class)
public interface GeoJSONGeometry {

}
