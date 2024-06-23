package request;

import constants.Header;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Resume  extends Header {


    private static final String ORDER_URL = BASE_URL + "resumes/";

    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }

    @Step("Get resume {requestBody}")
    public ValidatableResponse getResume(String requestBody) {
        return given()
                .spec(getRequestAuthSpec(requestBody))
                .get(ORDER_URL+"mine").then();
    }

    @Step("Сreate resume {requestBody}")
    public ValidatableResponse createResume(String requestBody) throws IOException {
        String jsonBody = generateStringFromResource("/Users/user/HtestingAPI/resume.json");
        return given()
                .spec(getRequestAuthSpec(requestBody))
                .body(jsonBody)
                .post(ORDER_URL).then();
    }

    @Step("Delete resume {}")
    public ValidatableResponse deleteResume(String requestBody, String request_id){
        System.out.println(ORDER_URL + request_id);
        return given()
                .spec(getRequestAuthSpec(requestBody))
                .delete(ORDER_URL + request_id ).then();

    }

    @Step("Get id resume")
    public Response getResumeId(String requestBody) {
        return given()
                .spec(getRequestAuthSpec(requestBody))
                .get(ORDER_URL+"mine");
    }
}
