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
