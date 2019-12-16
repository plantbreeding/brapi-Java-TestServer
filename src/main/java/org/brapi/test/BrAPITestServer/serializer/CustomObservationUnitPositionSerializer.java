package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.swagger.model.ObservationUnitPosition;

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
		jgen.writeStringField("blockNumber", unit.getBlockNumber());
		jgen.writeStringField("entryType", unit.getEntryType() == null ? "" : unit.getEntryType().toString());
		jgen.writeStringField("germplasmDbId", unit.getGermplasmDbId());
		jgen.writeStringField("germplasmName", unit.getGermplasmName());
		jgen.writeStringField("observationLevel", unit.getObservationLevel());
		jgen.writeStringField("observationUnitDbId", unit.getObservationUnitDbId());
		jgen.writeStringField("observationUnitName", unit.getObservationUnitName());
		jgen.writeStringField("positionCoordinateX", unit.getPositionCoordinateX());
		jgen.writeStringField("positionCoordinateXType", unit.getPositionCoordinateXType() == null ? "" : unit.getPositionCoordinateXType().toString());
		jgen.writeStringField("positionCoordinateY", unit.getPositionCoordinateY());
		jgen.writeStringField("positionCoordinateYType", unit.getPositionCoordinateYType() == null ? "" : unit.getPositionCoordinateYType().toString());
		jgen.writeStringField("replicate", unit.getReplicate());
		jgen.writeStringField("studyDbId", unit.getStudyDbId());
		jgen.writeStringField("X", unit.getX());
		jgen.writeStringField("Y", unit.getY());
		jgen.writeEndObject();
	}

}
