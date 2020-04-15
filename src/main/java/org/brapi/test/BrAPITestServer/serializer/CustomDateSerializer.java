package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;

import org.brapi.test.BrAPITestServer.service.DateUtility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<LocalDate>{
	
	private static final long serialVersionUID = 1L;

	public CustomDateSerializer() {
        this(null);
    }
	
	public CustomDateSerializer(Class<LocalDate> t) {
		super(t);
	}

	@Override
	public void serialize(LocalDate time, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
		dtfb.appendPattern(DateUtility.DATE_FORMAT);
		
		jgen.writeString(time.format(dtfb.toFormatter()));
	}

}
