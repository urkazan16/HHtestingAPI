package request;

import constants.Header;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Resume  extends Header {


    private static final String ORDER_URL = BASE_URL + "resumes/";

    @Step("Get order {requestBody}")
    public ValidatableResponse getOrder(String requestBody) {
        return given()
                .spec(getRequestAuthSpec(requestBody))
                .get(ORDER_URL+"mine").then();
    }

}
