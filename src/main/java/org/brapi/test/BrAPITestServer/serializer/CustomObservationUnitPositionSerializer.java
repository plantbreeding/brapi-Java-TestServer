package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.swagger.model.pheno.ObservationUnitPosition;

public class CustomObservationUnitPositionSerializer extends StdSerializer<ObservationUnitPosition>{
	
	private static final long serialVersionUID = 1L;

	public CustomObservationUnitPositionSerializer() {
        this(null);
    }
	
	public CustomObservationUnitPositionSerializer(Class<ObservationUnitPosition> t) {
		super(t);
	}

	@Override
	public void serialize(ObservationUnitPosition unit, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("entryType", unit.getEntryType() == null ? null : unit.getEntryType().toString());
		jgen.writeObjectField("observationLevel", unit.getObservationLevel());
		jgen.writeObjectField("observationLevelRelationships", unit.getObservationLevelRelationships());
		jgen.writeObjectField("coordinates", unit.getGeoCoordinates());
		jgen.writeObjectField("observationLevel", unit.getObservationLevel());
		jgen.writeStringField("positionCoordinateX", unit.getPositionCoordinateX());
		jgen.writeStringField("positionCoordinateXType", unit.getPositionCoordinateXType() == null ? null : unit.getPositionCoordinateXType().toString());
		jgen.writeStringField("positionCoordinateY", unit.getPositionCoordinateY());
		jgen.writeStringField("positionCoordinateYType", unit.getPositionCoordinateYType() == null ? null : unit.getPositionCoordinateYType().toString());
		jgen.writeEndObject();
	}

}
