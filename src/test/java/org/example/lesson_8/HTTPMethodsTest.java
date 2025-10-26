package org.example.lesson_8;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HTTPMethodsTest {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPostRequest() {
        String textBody = "Hello, world!";
        Response textResponse = given()
                .baseUri(BASE_URL)
                .contentType("text/plain; charset=UTF-8")
                .body(textBody)
                .when()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .extract().response();

        textResponse.then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(textBody))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers", hasKey("host"))
                .body("headers", hasKey("accept-encoding"))
                .body("headers", hasKey("user-agent"))
                .body("headers", hasKey("x-forwarded-proto"))
                .body("headers", hasKey("accept"))
                .body("headers.'content-type'", equalTo("text/plain; charset=UTF-8"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testUrlencodedPostRequest() {
        try {
            Response textResponse = given()
                    .baseUri("https://postman-echo.com")
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("message", "Hello, world!")
                    .log().all() // Логируем весь запрос
                    .when()
                    .post("/post")
                    .then()
                    .log().all() // Логируем весь ответ
                    .statusCode(500)
                    .extract().response();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testDeleteRequest() {

        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract().response();


        response.then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    @Test
    public void testGetRequest() {

        Map<String, String> expectedArgs = Map.of(
                "foo1", "bar1",
                "foo2", "bar2"
        );


        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .extract().response();

        // Проверяем тело ответа (полное сравнение значений всех полей на основе примера)
        response.then()
                .body("args", equalTo(expectedArgs))
                .body("data", nullValue())
                .body("files", nullValue())
                .body("form", nullValue())
                .body("headers", hasKey("host"))
                .body("headers", hasKey("accept-encoding"))
                .body("headers", hasKey("user-agent"))
                .body("headers", hasKey("x-forwarded-proto"))
                .body("headers", hasKey("accept"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPatchRequest() {
        // Отправляем PATCH-запрос
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract().response();


        response.then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testPutRequest() {

        String jsonBody = "{\"message\": \"Hello, world!\"}";


        Map<String, Object> expectedJson = Map.of("message", "Hello, world!");


        Response response = given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)  // Проверяем код ответа
                .extract().response();


        response.then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(expectedJson))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers", Matchers.hasKey("host"))
                .body("headers", Matchers.hasKey("accept-encoding"))
                .body("headers", Matchers.hasKey("user-agent"))
                .body("headers", Matchers.hasKey("x-forwarded-proto"))
                .body("headers", Matchers.hasKey("accept"))
                .body("headers", Matchers.hasKey("content-type"))
                .body("json", equalTo(expectedJson))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

}
