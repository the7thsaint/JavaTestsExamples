package apiTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static config.ApiSpecification.getRequestSpecification;
import static config.ApiSpecification.responseSpecification;
import static config.ApiSpecification.setSpecification;
import static io.restassured.RestAssured.given;
import static ru.testingisgood.contstants.PetStoreApi.GET_FIND_PET_BY_ID;
import static ru.testingisgood.contstants.PetStoreApi.PET_STORE_BASE_URL;
import static ru.testingisgood.contstants.PetStoreApi.POST_CREATE_NEW_PET;

public class PetStoreApiTests {
    private static final String NEW_PET_JSON_PATH = "src/test/resources/newPet.json";

    @Test
    @DisplayName("Проверка создания животного через ручку /v2/pet")
    public void checkIsNewPetCreated() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL), responseSpecification(200));
        given()
                .body(new File(NEW_PET_JSON_PATH))
                .when()
                .post(POST_CREATE_NEW_PET)
                .then().log().body();
    }

    @Test
    @DisplayName("Проверка поиска животного по id через ручку /v2/pet/{id}")
    public void getPetWithValidId() {
        setSpecification(getRequestSpecification(PET_STORE_BASE_URL), responseSpecification(200));
        given()
                .when()
                .get(String.format(GET_FIND_PET_BY_ID, "12345"))
                .then().log().body();
    }
}
