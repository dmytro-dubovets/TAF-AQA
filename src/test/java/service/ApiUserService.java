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
    private static final String USER_BY_NAME_ENDPOINT = "/user/%s";
    private static final String USER_LOGIN_ENDPOINT = "/user/login";
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

    public User getUserByName(String userName) {
        return RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .get(String.format(USER_BY_NAME_ENDPOINT, userName))
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().as(User.class);
    }

    public ApiResponse deleteCreatedUserByUserName(String userName, String password) {
        return RestAssured.given(requestSpecification)
                .auth()
                .basic(userName, password)
                .when()
                .delete(String.format(USER_BY_NAME_ENDPOINT, userName))
                .then()
                .log().all()
                .and()
                .statusCode(HttpStatus.OK.value())
                .extract().as(ApiResponse.class);
    }

    public ApiResponse login(User user) {
        return RestAssured.given(requestSpecification)
                .auth()
                .basic(user.getUserName(), user.getPassword())
                .when()
                .get(USER_LOGIN_ENDPOINT)
                .then()
                .log().all()
                .and()
                .statusCode(HttpStatus.OK.value())
                .extract().as(ApiResponse.class);
    }
}
