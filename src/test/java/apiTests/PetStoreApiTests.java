package apiTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectsConfiguration.apiDataGenerators.PetStorePetData;
import projectsConfiguration.apiDataGenerators.PetStoreUsersData;

import java.io.File;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static projectsConfiguration.apiConf.ApiSpecification.getRequestSpecification;
import static projectsConfiguration.apiConf.ApiSpecification.responseSpecification;
import static projectsConfiguration.apiConf.ApiSpecification.setSpecification;
import static projectsConfiguration.apiDataGenerators.PetStoreUsersData.getUserData;
import static ru.testingisgood.contstants.PetStoreApi.GET_FIND_PET_BY_ID;
import static ru.testingisgood.contstants.PetStoreApi.PET_STORE_BASE_URL;
import static ru.testingisgood.contstants.PetStoreApi.POST_CREATE_NEW_PET;
import static ru.testingisgood.contstants.PetStoreApi.POST_CREATE_SINGLE_USER;

public class PetStoreApiTests {
    private static final String NEW_PET_JSON_PATH = "src/test/resources/newPet.json";

    //POST запрос с использованием чтения из файла
    @Test
    @DisplayName("Проверка создания животного через ручку /v2/pet")
    public void checkIsNewPetCreated() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL, POST_CREATE_NEW_PET), responseSpecification(200));
        given()
                .body(new File(NEW_PET_JSON_PATH))
                .when()
                .post()
                .then();
    }

    //POST запрос с использованием POJO класса и билдера
    @Test
    @DisplayName("Проверка создания нового пользователя с дальнейшей валидацией поля message")
    public void createNewSingleUserWithCode200() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL, POST_CREATE_SINGLE_USER), responseSpecification(200));
        given()
                .body(getUserData())
                .when().post()
                .then().assertThat().body("message", equalTo(valueOf(PetStoreUsersData.getUserData().getId())));
    }


    @Test
    @DisplayName("Проверка поиска животного по id через ручку /v2/pet/{id}")
    public void getPetWithValidId() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL, String.format(GET_FIND_PET_BY_ID, "12345")),
                responseSpecification(200));
        given()
                .when()
                .get()
                .then();
    }

    //POST запрос с использованием POJO класса и билдера
    @Test
    @DisplayName("Создание нового животного с кодов ответа 200")
    public void checkCreateNewPetWithCode200() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL, POST_CREATE_NEW_PET),
                responseSpecification(200));
        given()
                .body(PetStorePetData.getPetData())
                .when().post()
                .then().assertThat().body("id", equalTo(123));
    }
}
