package org.brapi.test.BrAPITestServer.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.model.germ.GermplasmStorageTypes;
import io.swagger.model.germ.GermplasmStorageTypesEnum;

public class CustomGermplasmStorageTypesDeserializer extends JsonDeserializer<GermplasmStorageTypes> {
    @Override
    public GermplasmStorageTypes deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);
        if (root.has("code")) {
            String code = root.get("code").asText();
            return new GermplasmStorageTypes(GermplasmStorageTypesEnum.fromValue(code));
        }
        return null;
    }
}
