package com.sp.fc.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicAuthenticationTest {

    @LocalServerPort
    int port;

    RestTemplate client = new RestTemplate();

    private String greetingUrl() {
        return "http://localhost:" + port + "/greeting";
    }

    @Test
    void 인증_실패_GET() {
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            client.getForObject(greetingUrl(), String.class);
        });

        assertEquals(401, exception.getRawStatusCode());
    }

    @Test
    void 인증_성공_GET() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(
                "user:1234".getBytes()
        ));

        HttpEntity entity = new HttpEntity(null, headers);

        ResponseEntity<String> responseEntity =
                client.exchange(greetingUrl(), HttpMethod.GET, entity, String.class);

        assertEquals("hello", responseEntity.getBody());
    }

    @Test
    void 인증_성공_GET_2() {
        TestRestTemplate testClient = new TestRestTemplate("user", "1234");
        String response = testClient.getForObject(greetingUrl(), String.class);

        assertEquals("hello", response);
    }

    @Test
    void 인증_성공_POST() {
        TestRestTemplate testClient = new TestRestTemplate("user", "1234");
        ResponseEntity<String> response = testClient.postForEntity(greetingUrl(), "test", String.class);

        assertEquals("hello test", response.getBody());
    }
}
