package projectsConfiguration.apiConf;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.http.ContentType.JSON;

public class ApiSpecification {

    public static RequestSpecification getRequestSpecification(String baseUrl, String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .setAccept(JSON)
                .setContentType(JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification(int responseCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(responseCode)
                .build();
    }

    public static void setSpecification(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
