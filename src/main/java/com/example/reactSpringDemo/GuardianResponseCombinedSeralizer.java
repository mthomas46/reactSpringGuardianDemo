package com.example.reactSpringDemo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class GuardianResponseCombinedSeralizer {
    public static class GuardianResponseSeralizer extends JsonSerializer<GuardianResponse> {
        @Override
        public void serialize(GuardianResponse guardianResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        }
    }

    public static class GuardianResponseDeseralizer extends JsonDeserializer<GuardianResponse> {
        @Override
        public GuardianResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            ObjectMapper objectMapper = new ObjectMapper();
            Guardian[] guardians = objectMapper.readValue(treeNode.get("Response").toString(), Guardian[].class);
            int ErrorCode = Integer.parseInt(treeNode.get("ErrorCode").toString());
            int ThrottleSeconds = Integer.parseInt(treeNode.get("ThrottleSeconds").toString());
            String ErrorStatus = treeNode.get("ErrorStatus").toString();
            String Message = treeNode.get("Message").toString();
            return new GuardianResponse(guardians, ErrorCode, ThrottleSeconds, ErrorStatus, Message);

        }
    }
}
