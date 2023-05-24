package com.nnt.data.springbootrest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeControllerTest {

    @Test
    public void testHello() {
        HomeController controller = new HomeController();

        ResponseEntity<?> responseEntity = controller.hello();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("Message", "Hello");
        assertEquals(expectedMap, responseEntity.getBody());
    }
}
