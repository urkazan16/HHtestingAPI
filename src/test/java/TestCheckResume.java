import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import request.Resume;
import user.UserAuthorizationFields;

//import static jdk.nashorn.tools.Shell.SUCCESS;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class TestCheckResume {

    private UserAuthorizationFields userToken;

    public Resume getResume;
    @Before
    public void setUp() {
        getResume = new Resume();
        userToken = new UserAuthorizationFields();
//        userRequest = new UserRequest();
//        userRegistrationFields = RandomTestUser.getRandomRegistration();
//        token = userRequest.regUser(userRegistrationFields).path(ACCESS_TOKEN);
    }

    @After
    public void clearDate() {
//        if (token != null && !token.isBlank()) {
//            userRequest.deletingUser(token);
//        }
    }

    @Test
    @DisplayName("Check Resume")
    public void checkResume() throws IOException {
        ValidatableResponse response = getResume.getOrder(userToken.getToken());
        response.assertThat()
                .statusCode(200)
                .and();
//                .body("SUCCESS", equalTo(true));
    }
}
