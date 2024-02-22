package api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class PetstoreTest {

    @Test
    void findByStatus() {
//        Response response = get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending");
//
//        int statusCode = response.statusCode();
//        Assertions.assertEquals(200, statusCode);
//
//        Long o = response.jsonPath().get("id[1]");
//        System.out.println();

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.port = 443;
        RestAssured.rootPath = "/v2/pet";

        RequestSpecification specification = RestAssured.given()
                .port(443)
                .basePath("/v2/pet")
                .log().all();

        specification
                .get("findByStatus")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(JSON)
                .header("access-control-allow-origin", "*")
                .body("$", hasSize(6))
                .body("$.id", not(is(0)));

        specification
                .params("status", "pending")
                .get("findByStatus")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .header("access-control-allow-origin", "*")
                .body("$", hasSize(6))
                .body("$.id", not(is(0)));

//        Pet pet = when()
//                .get("https://petstore.swagger.io/v2/pet/9223372036854773000")
//                .as(Pet.class);
//
//        Assertions.assertEquals("dogs1", pet.name);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Pet {
        private Long id;
        private String name;
        private Category category;

        @JsonIgnoreProperties(ignoreUnknown = true)
        static class Category {
            private Long id;
            private String name;
        }
    }
}
