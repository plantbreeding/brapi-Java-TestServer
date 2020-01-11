package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.swagger.model.ObservationUnit;

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
		jgen.writeStringField("blockNumber", unit.getBlockNumber());
		jgen.writeStringField("entryNumber", unit.getEntryNumber());
		jgen.writeStringField("entryType", unit.getEntryType());
		jgen.writeStringField("germplasmDbId", unit.getGermplasmDbId());
		jgen.writeStringField("germplasmName", unit.getGermplasmName());
		jgen.writeStringField("locationDbId", unit.getLocationDbId());
		jgen.writeStringField("locationName", unit.getLocationName());
		jgen.writeStringField("observationLevel", unit.getObservationLevel());
		jgen.writeStringField("observationLevels", unit.getObservationLevels());
		jgen.writeObjectField("observations", unit.getObservations());
		jgen.writeStringField("observationUnitDbId", unit.getObservationUnitDbId());
		jgen.writeStringField("observationUnitName", unit.getObservationUnitName());
		jgen.writeObjectField("observationUnitXref", unit.getObservationUnitXref());
		jgen.writeStringField("pedigree", unit.getPedigree());
		jgen.writeStringField("plantNumber", unit.getPlantNumber());
		jgen.writeStringField("plotNumber", unit.getPlotNumber());
		jgen.writeStringField("positionCoordinateX", unit.getPositionCoordinateX());
		jgen.writeStringField("positionCoordinateXType", unit.getPositionCoordinateXType() == null ? null : unit.getPositionCoordinateXType().toString());
		jgen.writeStringField("positionCoordinateY", unit.getPositionCoordinateY());
		jgen.writeStringField("positionCoordinateYType", unit.getPositionCoordinateYType() == null ? null : unit.getPositionCoordinateYType().toString());
		jgen.writeStringField("programDbId", unit.getProgramDbId());
		jgen.writeStringField("programName", unit.getProgramName());
		jgen.writeStringField("replicate", unit.getReplicate());
		jgen.writeStringField("studyDbId", unit.getStudyDbId());
		jgen.writeStringField("studyLocation", unit.getStudyLocation());
		jgen.writeStringField("studyLocationDbId", unit.getStudyLocationDbId());
		jgen.writeStringField("studyName", unit.getStudyName());
		jgen.writeObjectField("treatments", unit.getTreatments());
		jgen.writeStringField("trialDbId", unit.getTrialDbId());
		jgen.writeStringField("trialName", unit.getTrialName());
		jgen.writeStringField("X", unit.getX());
		jgen.writeStringField("Y", unit.getY());
		jgen.writeEndObject();
	}
}
