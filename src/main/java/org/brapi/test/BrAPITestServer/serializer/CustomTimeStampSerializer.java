package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;

import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatterBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomTimeStampSerializer extends StdSerializer<OffsetDateTime>{
	
	private static final long serialVersionUID = 1L;

	public CustomTimeStampSerializer() {
        this(null);
    }
	
	public CustomTimeStampSerializer(Class<OffsetDateTime> t) {
		super(t);
	}

	@Override
	public void serialize(OffsetDateTime time, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
		dtfb.appendPattern(DateUtility.TIME_FORMAT);
		
		jgen.writeString(time.format(dtfb.toFormatter()));
	}

}
