package com.mytech.articleservice;

//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.Test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

//public class  ArticleControllerEndToEndTest {

//    @Test
//    public void testCreateArticle() throws ParseException {
//        // Set the base URL for your API
//        RestAssured.baseURI = "http://localhost:8081";
//
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//        Date creationDate = date.parse("2023-06-16");
//
//        CreateArticleRequest request = new CreateArticleRequest(1, 123, "Sample Article", "Sample Content", creationDate);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(request)
//                .when()
//                .post("/articles")
//                .then()
//                .statusCode(200)
//                .body("userId", equalTo(123))
//                .body("articleTitle", equalTo("Sample Article"))
//                .body("articleContext", equalTo("Sample Content"));
//    }
//}