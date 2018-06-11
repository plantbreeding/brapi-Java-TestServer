package org.brapi.test.BrAPITestServer;

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
	public void serialize(ObservationUnitPosition position, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("X", position.getX());
		jgen.writeStringField("Y", position.getY());
		jgen.writeObjectField("additionalInfo", position.getAdditionalInfo());
		jgen.writeStringField("blockNumber", position.getBlockNumber());
		jgen.writeStringField("entryType", position.getEntryType().name());
		jgen.writeStringField("germplasmDbId", position.getGermplasmDbId());
		jgen.writeStringField("germplasmName", position.getGermplasmName());
		jgen.writeStringField("observationLevel", position.getObservationLevel());
		jgen.writeStringField("observationUnitDbId", position.getObservationUnitDbId());
		jgen.writeStringField("observationUnitName", position.getObservationUnitName());
		jgen.writeStringField("replicate", position.getReplicate());
		jgen.writeStringField("studyDbId", position.getStudyDbId());
		jgen.writeEndObject();
	}

}
