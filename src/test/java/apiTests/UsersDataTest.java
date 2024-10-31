package apiTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.ColorPojoFullData;
import pojo.UserPojoFullData;

import java.io.File;
import java.util.List;

import static config.ApiSpecification.getRequestSpecification;
import static config.ApiSpecification.responseSpecification;
import static config.ApiSpecification.setSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static ru.testingisgood.contstants.ReqresInApi.REQRES_BASE_URL;
import static ru.testingisgood.contstants.ReqresInApi.GET_API_UNKNOWN;
import static ru.testingisgood.contstants.ReqresInApi.GET_API_USERS;
import static ru.testingisgood.contstants.ReqresInApi.POST_API_USERS;

public class UsersDataTest {

    public static final String NEW_USER_JSON_PATH = "src/test/resources/newUser.json";

    @Test
    public void getListOfUsersWithCode200(){
        setSpecification(getRequestSpecification(REQRES_BASE_URL), responseSpecification(200));
        given()
                .when()
                .get(GET_API_USERS)
                .then();
    }

    @Test
    public void postNewUserWithCode201(){
        setSpecification(getRequestSpecification(REQRES_BASE_URL), responseSpecification(201));
        given()
                .body(new File(NEW_USER_JSON_PATH))
                .when()
                .post(POST_API_USERS)
                .then().statusCode(201).log().body();
    }

    @Test
    public void checkSingleUserName(){
        setSpecification(getRequestSpecification(REQRES_BASE_URL), responseSpecification(200));
        given()
                .when()
                .get(GET_API_USERS)
                .then().log().body()
                .body("page", equalTo(2));
    }

    @Test
    public void checkUserData(){
        setSpecification(getRequestSpecification(REQRES_BASE_URL), responseSpecification(200));
        List<UserPojoFullData> users = given()
                .when()
                .get(GET_API_USERS)
                .then()
                .log().body().extract().jsonPath().getList("data", UserPojoFullData.class);

        users.forEach(u -> Assertions.assertTrue(u.getAvatar().contains("reqres.in")));
    }

    @Test
    public void checkColorData(){
        setSpecification(getRequestSpecification(REQRES_BASE_URL), responseSpecification(200));
        List<ColorPojoFullData> colors = given()
                .when()
                .get(GET_API_UNKNOWN)
                .then()
                .log().body().extract().jsonPath().getList("data", ColorPojoFullData.class);

        colors.forEach(c -> Assertions.assertTrue(c.getYear() >= 2000));
    }
}
