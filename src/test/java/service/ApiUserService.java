package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.springframework.http.HttpStatus;
import response.ApiResponse;

public class ApiUserService {

    private static final String CREATE_USER_ENDPOINT = "/user";
    private final RequestSpecification requestSpecification;

    public ApiUserService(String applicationUrl) {
        requestSpecification = RestAssured.given().baseUri(applicationUrl).and().log().all();
    }

    public ApiResponse createNewUser(User user) {
        return RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(CREATE_USER_ENDPOINT)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().as(ApiResponse.class);
    }
}
