import io.qameta.allure.junit4.DisplayName;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.ResponseText.RESUME_ITEMS;
import static org.hamcrest.CoreMatchers.notNullValue;

public class TestCheckCreateResume extends ConfTest{

//private String resumeId;

    @Test
    @DisplayName("Проверка создания резюме")
    public void checkCreateResume() throws IOException {
        ValidatableResponse response = getResume.createResume(userToken.getToken());
        response.assertThat()
                .statusCode(201)
                .and().body(RESUME_ITEMS, notNullValue());
    }

    @Test
    @DisplayName("Удаление резюме")
    public void checkDeleteResume() throws IOException {
        Response responseResume = getResume.getResumeId(userToken.getToken());
       String resumeId = responseResume.path("items.id").toString().replaceAll("\\[|\\]", "");
        ValidatableResponse response = getResume.deleteResume(userToken.getToken(), resumeId);
        response.assertThat()
                .statusCode(204)
                .and().body(RESUME_ITEMS, notNullValue());
    }

}
