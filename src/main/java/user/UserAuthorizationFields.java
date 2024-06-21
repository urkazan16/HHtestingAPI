package user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserAuthorizationFields {

    private String token;

    public UserAuthorizationFields(String token) {
        this.token = token;
    }
    public UserAuthorizationFields() {
    }

    public String getToken() throws IOException {
//        return token;
        String rootPath = "";
        String appConfigPath = rootPath + "ServerConfig.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        String userToken = appProps.getProperty("token");
        return userToken;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserTokenFields{" +
                "token='" + token + '\'' +
                '}';
    }
}
