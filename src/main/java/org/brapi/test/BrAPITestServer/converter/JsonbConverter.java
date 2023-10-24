package org.brapi.test.BrAPITestServer.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class JsonbConverter implements AttributeConverter<JsonbObject, String> {

    private final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(JsonbObject jsonb) {
        try {
            return mapper.writeValueAsString(jsonb.value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JsonbObject convertToEntityAttribute(String dbData) {
        try {
            return new JsonbObject(mapper.readValue(dbData, Object.class));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}