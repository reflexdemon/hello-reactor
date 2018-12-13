package io.vpv.reactive.helloreactor.controller.api;

import io.vpv.reactive.helloreactor.HelloReactorApplicationTests;
import io.vpv.reactive.helloreactor.model.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PersonControllerTest extends HelloReactorApplicationTests {
    // Spring Boot will create a `WebTestClient` for you,
    // already configure and ready to issue requests against "localhost:RANDOM_PORT"
    @Autowired
    private WebTestClient webTestClient;

    private static Map<String, Person> customerMap = new HashMap<>();

    @BeforeClass
    public static void setUp() throws Exception {
        customerMap.put("John", new Person("John", "Doe"));
        customerMap.put("Jane", new Person("Jane", "Doe"));
    }

    @Test
    public void findAll() {
        webTestClient
                // Create a GET request to test an endpoint
                .get().uri("/api/person")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus().isOk()
                .expectBodyList(Person.class)
                .contains(customerMap.get("John"), customerMap.get("Jane"));
    }
}