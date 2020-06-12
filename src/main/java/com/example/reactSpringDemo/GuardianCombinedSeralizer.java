package com.example.reactSpringDemo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class GuardianCombinedSeralizer {

//    public static class GuardianSeralizer extends JsonSerializer<Guardian> {
//        @Override
//        public void serialize(Guardian guardian, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        }
//    }

    public static class GuardianDeserializer extends JsonDeserializer<Guardian> {

        @Override
        public Guardian deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);


            TextNode displayName = (TextNode) treeNode.get("displayName");
            TextNode membershipId = (TextNode) treeNode.get("membershipId");
            return new Guardian(null, 0, false, null, membershipId.asText(), displayName.asText());
        }
    }
}
