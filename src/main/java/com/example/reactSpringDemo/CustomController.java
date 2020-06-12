package com.example.reactSpringDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class CustomController{
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    @GetMapping(value = "/import-Guardian")
    public String importGuardian(@RequestParam(name = "displayName", required = true) String name) throws JsonProcessingException {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-API-Key", "224e223eb6984c7d9134b321a5cfac13");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        final String uri = "https://www.bungie.net/Platform/Destiny2/SearchDestinyPlayer/-1/afroKing42/";

        String body = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper objectMapper = new ObjectMapper();

        GuardianResponse GR= objectMapper.readValue(body, GuardianResponse.class);

        return objectMapper.writeValueAsString(GR);
    }
}
