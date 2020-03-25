package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.swagger.model.pheno.ObservationUnit;

public class CustomObservationUnitSerializer extends StdSerializer<ObservationUnit>{
	
	private static final long serialVersionUID = 1L;

	public CustomObservationUnitSerializer() {
        this(null);
    }
	
	public CustomObservationUnitSerializer(Class<ObservationUnit> t) {
		super(t);
	}

	@Override
	public void serialize(ObservationUnit unit, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("germplasmDbId", unit.getGermplasmDbId());
		jgen.writeStringField("germplasmName", unit.getGermplasmName());
		jgen.writeStringField("locationDbId", unit.getLocationDbId());
		jgen.writeStringField("locationName", unit.getLocationName());
		jgen.writeObjectField("observations", unit.getObservations());
		jgen.writeStringField("observationUnitDbId", unit.getObservationUnitDbId());
		jgen.writeStringField("observationUnitName", unit.getObservationUnitName());
		jgen.writeObjectField("observationUnitXref", unit.getExternalReferences());
		jgen.writeStringField("programDbId", unit.getProgramDbId());
		jgen.writeStringField("programName", unit.getProgramName());
		jgen.writeStringField("studyDbId", unit.getStudyDbId());
		jgen.writeStringField("locationDbId", unit.getLocationDbId());
		jgen.writeStringField("locationName", unit.getLocationName());
		jgen.writeStringField("studyName", unit.getStudyName());
		jgen.writeObjectField("treatments", unit.getTreatments());
		jgen.writeStringField("trialDbId", unit.getTrialDbId());
		jgen.writeStringField("trialName", unit.getTrialName());
		jgen.writeEndObject();
	}
}
