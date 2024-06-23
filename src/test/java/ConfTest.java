import org.junit.After;
import org.junit.Before;
import request.Resume;
import user.UserAuthorizationFields;

public class ConfTest {
    public UserAuthorizationFields userToken;

    public Resume getResume;
    @Before
    public void setUp() {
        getResume = new Resume();
        userToken = new UserAuthorizationFields();

    }

    @After
    public void clearDate() {
    }
}
