package projectsConfiguration.apiDataGenerators;

import pojo.PostNewUserPetStore;

public class PetStoreUsersData {

    public static PostNewUserPetStore getUserData() {
        return PostNewUserPetStore
                .builder()
                .firstName("Pavel")
                .lastName("Vinogradov")
                .password("12345")
                .userStatus(1)
                .phone("89999999999")
                .id(234)
                .email("qa@test.qa")
                .username("aQa")
                .build();
    }
}
