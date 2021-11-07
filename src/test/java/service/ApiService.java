package service;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    private final String USERS_ENDPOINT = "/users";
    private final String SINGLE_USER_ENDPOINT = "/users/%s";
    private final RequestSpecification requestSpecification;

    public ApiService(String applicationUrl) {
        requestSpecification = RestAssured.given().baseUri(applicationUrl);
    }

    public Response getAllUsers() {
        return RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .get(USERS_ENDPOINT);
    }

    public Response getSingleUser(int userId) {
        return RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .get(String.format(SINGLE_USER_ENDPOINT, userId));
    }
}
