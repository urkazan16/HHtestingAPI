import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static constants.ResponseText.RESUME_ITEMS;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestCheckResume extends ConfTest {

    @Test
    @DisplayName("Проверка наличия резюме")
    public void checkResume() throws IOException {
        ValidatableResponse response = getResume.getResume(userToken.getToken());
        response.assertThat()
                .statusCode(200)
                .and().body(RESUME_ITEMS, notNullValue());
    }

    @Test
    @DisplayName("Проверка статуса резюме")
    public void checkStatusResume() throws IOException, InterruptedException {
        ValidatableResponse response = getResume.getResume(userToken.getToken());
        List<String> accessTypeNames = response.extract().path("items.access.type.name");
        for (String currentKey : accessTypeNames.get(1).split(",")) {
            assertThat(currentKey, equalTo("не опубликовано"));
        }
    }
}
