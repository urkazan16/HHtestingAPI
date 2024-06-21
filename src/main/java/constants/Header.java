package constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Header {
    protected static final String BASE_URL = "https://api.hh.ru/";

    protected RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    protected RequestSpecification getRequestAuthSpec(String body) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", body)
                .setBaseUri(BASE_URL)
                .build();
    }
}
