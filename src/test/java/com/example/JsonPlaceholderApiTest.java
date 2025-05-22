package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JsonPlaceholderApiTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetPost() {
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .time(lessThan(1000L)) // Response time should be less than 1 second
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("body", notNullValue())
                .body("userId", notNullValue())
                .extract()
                .response();

        // Additional assertions using JUnit
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getTime() < 1000); // Response time check
        
        // Log response time
        System.out.println("GET Request Response Time: " + response.getTime() + " ms");
    }

    @Test
    public void testCreatePost() {
        String requestBody = "{\n" +
                "    \"title\": \"Test Title\",\n" +
                "    \"body\": \"Test Body\",\n" +
                "    \"userId\": 1\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .time(lessThan(1000L)) // Response time should be less than 1 second
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("id", notNullValue())
                .body("title", equalTo("Test Title"))
                .body("body", equalTo("Test Body"))
                .body("userId", equalTo(1))
                .extract()
                .response();

        // Additional assertions using JUnit
        assertEquals(201, response.getStatusCode());
        assertTrue(response.getTime() < 1000); // Response time check
        
        // Log response time
        System.out.println("POST Request Response Time: " + response.getTime() + " ms");
    }
} 