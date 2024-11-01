package apiTests;

import org.junit.jupiter.api.Test;
import pojo.ColorPojoFullData;
import pojo.UserPojoFullData;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static projectsConfiguration.apiConf.ApiSpecification.getRequestSpecification;
import static projectsConfiguration.apiConf.ApiSpecification.responseSpecification;
import static projectsConfiguration.apiConf.ApiSpecification.setSpecification;
import static ru.testingisgood.contstants.ReqresInApi.GET_API_UNKNOWN;
import static ru.testingisgood.contstants.ReqresInApi.GET_API_USERS;
import static ru.testingisgood.contstants.ReqresInApi.POST_API_USERS;
import static ru.testingisgood.contstants.ReqresInApi.REQRES_BASE_URL;

public class UsersDataTest {

    public static final String NEW_USER_JSON_PATH = "src/test/resources/newUser.json";

    @Test
    public void getListOfUsersWithCode200() {
        setSpecification(getRequestSpecification(REQRES_BASE_URL, GET_API_USERS), responseSpecification(200));
        given()
                .when()
                .get()
                .then();
    }

    @Test
    public void postNewUserWithCode201() {
        setSpecification(getRequestSpecification(REQRES_BASE_URL, POST_API_USERS), responseSpecification(201));
        given()
                .body(new File(NEW_USER_JSON_PATH))
                .when()
                .post()
                .then().log().body();
    }

    @Test
    public void checkSingleUserName() {
        setSpecification(getRequestSpecification(REQRES_BASE_URL, GET_API_USERS), responseSpecification(200));
        given()
                .when()
                .get()
                .then().assertThat()
                .body("data[0].first_name", equalTo("George"));
    }

    @Test
    public void checkUserData() {
        setSpecification(getRequestSpecification(REQRES_BASE_URL, GET_API_USERS), responseSpecification(200));
        List<UserPojoFullData> users = given()
                .when()
                .get()
                .then()
                .log().body().extract().jsonPath().getList("data", UserPojoFullData.class);

        users.forEach(u -> assertTrue(u.getAvatar().contains("reqres.in")));
    }

    @Test
    public void checkColorsYear() {
        setSpecification(getRequestSpecification(REQRES_BASE_URL, GET_API_UNKNOWN), responseSpecification(200));
        List<ColorPojoFullData> colors = given()
                .when()
                .get()
                .then()
                .log().body().extract().jsonPath().getList("data", ColorPojoFullData.class);

        colors.forEach(c -> assertTrue(c.getYear() >= 2000));
    }
}
