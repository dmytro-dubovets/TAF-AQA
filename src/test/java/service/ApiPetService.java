package service;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiPetService {

    private final String FIND_PETS_BY_STATUS = "/pet/findByStatus";
    private final RequestSpecification requestSpecification;

    public ApiPetService(String applicationUrl) {
        requestSpecification = RestAssured.given().baseUri(applicationUrl).and().log().all();
    }

    public List<Pet> findPetsByStatus() {
        final Pet[] pets = RestAssured.given(requestSpecification)
                .queryParam("status", "available")
                .get(FIND_PETS_BY_STATUS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(Pet[].class);
        return Arrays.asList(pets);
    }

}
