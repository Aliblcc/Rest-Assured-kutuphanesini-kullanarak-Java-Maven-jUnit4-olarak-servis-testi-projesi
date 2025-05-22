package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JsonPlaceholderApiAdvancedTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        System.out.println("\n🚀 API Testleri Başlıyor...\n");
    }

    @Test
    public void testGetAllPosts() {
        System.out.println("\n📌 Test: Tüm Postları Getirme");
        Response response = given()
                .when()
                .get("/posts")
                .then()
                .time(lessThan(1000L))
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0))
                .body("findAll { it.id > 0 }.size()", greaterThan(0))
                .extract()
                .response();

        System.out.println("✅ Response Time: " + response.getTime() + " ms");
        if (response.getTime() < 1000) {
            System.out.println("✅ Test başarılı: Response time 1 saniyenin altında");
        }
    }

    @Test
    public void testDeletePost() {
        System.out.println("\n📌 Test: Post Silme");
        Response response = given()
                .when()
                .delete("/posts/1")
                .then()
                .time(lessThan(1000L))
                .statusCode(200)
                .extract()
                .response();

        System.out.println("✅ Response Time: " + response.getTime() + " ms");
        if (response.getTime() < 1000) {
            System.out.println("✅ Test başarılı: Response time 1 saniyenin altında");
        }
    }

    @Test
    public void testGetPostWithQueryParams() {
        System.out.println("\n📌 Test: Query Parametreleri ile Post Getirme");
        Response response = given()
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .time(lessThan(1000L))
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("findAll { it.userId == 1 }.size()", greaterThan(0))
                .extract()
                .response();

        System.out.println("✅ Response Time: " + response.getTime() + " ms");
        if (response.getTime() < 1000) {
            System.out.println("✅ Test başarılı: Response time 1 saniyenin altında");
        }
    }

    @Test
    public void testGetPostComments() {
        System.out.println("\n📌 Test: Post Yorumlarını Getirme");
        Response response = given()
                .when()
                .get("/posts/1/comments")
                .then()
                .time(lessThan(1000L))
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0))
                .body("findAll { it.postId == 1 }.size()", greaterThan(0))
                .extract()
                .response();

        System.out.println("✅ Response Time: " + response.getTime() + " ms");
        if (response.getTime() < 1000) {
            System.out.println("✅ Test başarılı: Response time 1 saniyenin altında");
        }
    }
} 