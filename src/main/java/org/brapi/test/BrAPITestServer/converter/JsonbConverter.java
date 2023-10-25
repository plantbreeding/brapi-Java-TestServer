package org.brapi.test.BrAPITestServer.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class JsonbConverter implements AttributeConverter<Object, String> {

    private final static ObjectMapper mapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JsonbConverter.class);

    @Override
    public String convertToDatabaseColumn(Object jsonb) {
        try {
            log.debug(mapper.writeValueAsString(jsonb));
            return mapper.writeValueAsString(jsonb);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}