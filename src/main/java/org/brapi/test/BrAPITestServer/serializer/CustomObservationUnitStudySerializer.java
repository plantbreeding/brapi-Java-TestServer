package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.swagger.model.ObservationSummary;
import io.swagger.model.ObservationUnitPosition;
import io.swagger.model.ObservationUnitStudy;
import io.swagger.model.ObservationUnitXref;

public class CustomObservationUnitStudySerializer extends StdSerializer<ObservationUnitStudy>{
	
	private static final long serialVersionUID = 1L;

	public CustomObservationUnitStudySerializer() {
        this(null);
    }
	
	public CustomObservationUnitStudySerializer(Class<ObservationUnitStudy> t) {
		super(t);
	}

	@Override
	public void serialize(ObservationUnitStudy unit, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("X", unit.getX());
		jgen.writeStringField("Y", unit.getY());
		jgen.writeStringField("blockNumber", unit.getBlockNumber());
		jgen.writeStringField("entryNumber", unit.getEntryNumber());
		jgen.writeStringField("entryType", unit.getEntryType());
		jgen.writeStringField("germplasmDbId", unit.getGermplasmDbId());
		jgen.writeStringField("germplasmName", unit.getGermplasmName());
		jgen.writeStringField("observationUnitDbId", unit.getObservationUnitDbId());
		jgen.writeStringField("observationUnitName", unit.getObservationUnitName());
		jgen.writeObjectField("observationUnitXref", unit.getObservationUnitXref());
		jgen.writeObjectField("observations", unit.getObservations());
		jgen.writeStringField("pedigree", unit.getPedigree());
		jgen.writeStringField("plantNumber", unit.getPlantNumber());
		jgen.writeStringField("plotNumber", unit.getPlotNumber());
		jgen.writeStringField("replicate", unit.getReplicate());
		jgen.writeEndObject();
	}
}
