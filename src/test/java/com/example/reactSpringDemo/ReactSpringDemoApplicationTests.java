package com.example.reactSpringDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ReactSpringDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testDeserializeGuardian() throws IOException {
		String json = "{\"iconPath\":\"/img/theme/bungienet/icons/psnLogo.png\",\"crossSaveOverride\":0,\"isPublic\":false,\"membershipType\":2,\"membershipId\":\"4611686018488683158\",\"displayName\":\"afroKing42\"}";
		Guardian response = objectMapper.readValue(json, Guardian.class);
		System.out.println(response);
	}

	@Test
	public void testDeserializeGuardians() throws IOException {
		String json = "[{\"iconPath\":\"/img/theme/bungienet/icons/psnLogo.png\",\"crossSaveOverride\":0,\"isPublic\":false,\"membershipType\":2,\"membershipId\":\"4611686018488683158\",\"displayName\":\"afroKing42\"},{\"iconPath\":\"/img/theme/bungienet/icons/steamLogo.png\",\"crossSaveOverride\":0,\"isPublic\":false,\"membershipType\":3,\"membershipId\":\"4611686018471247673\",\"displayName\":\"Afroking42\"}]";
		Guardian[] response = objectMapper.readValue(json, Guardian[].class);
		System.out.println(response);
	}
	@Test
	public void testDeserializeGuardianResponse() throws IOException {
		String json = "{\"Response\":[{\"iconPath\":\"/img/theme/bungienet/icons/psnLogo.png\",\"crossSaveOverride\":0,\"isPublic\":false,\"membershipType\":2,\"membershipId\":\"4611686018488683158\",\"displayName\":\"afroKing42\"},{\"iconPath\":\"/img/theme/bungienet/icons/steamLogo.png\",\"crossSaveOverride\":0,\"isPublic\":false,\"membershipType\":3,\"membershipId\":\"4611686018471247673\",\"displayName\":\"Afroking42\"}],\"ErrorCode\":1,\"ThrottleSeconds\":0,\"ErrorStatus\":\"Success\",\"Message\":\"Ok\",\"MessageData\":{}}";
		GuardianResponse response = objectMapper.readValue(json, GuardianResponse.class);
		System.out.println(response);
	}
}
