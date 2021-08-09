package org.brapi.test.BrAPITestServer.serializer;

import org.springframework.core.convert.converter.Converter;

import io.swagger.model.WSMIMEDataTypes;

public class CustomStringToEnumConverter implements Converter<String, WSMIMEDataTypes> {
    @Override
    public WSMIMEDataTypes convert(String source) {
    	WSMIMEDataTypes dataType = WSMIMEDataTypes.fromValue(source);
    	if (dataType == null) {
    		dataType = WSMIMEDataTypes.valueOf(source);
    	}
    	return dataType;
    }
}
