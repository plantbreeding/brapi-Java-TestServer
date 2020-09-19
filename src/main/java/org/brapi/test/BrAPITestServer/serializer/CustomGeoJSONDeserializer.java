package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.model.GeoJSONGeometry;
import io.swagger.model.PointGeometry;
import io.swagger.model.PolygonGeometry;

public class CustomGeoJSONDeserializer extends JsonDeserializer<GeoJSONGeometry> {
    @Override
    public GeoJSONGeometry deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        if (root.has("type") && root.get("type").asText().equals("Point")) {
            return mapper.readValue(root.toString(), PointGeometry.class);
        }
        return mapper.readValue(root.toString(), PolygonGeometry.class);
    }
}
