package projectsConfiguration.apiDataGenerators;

import pojo.test.Category;
import pojo.test.NewPetRequest;
import pojo.test.TagsItem;

import java.util.Arrays;



public class PetData {

    public static NewPetRequest getPetData(){
        return NewPetRequest
                .builder()
                .id(123)
                .name("Sharik")
                .status("availible")
                .photoUrls(Arrays.asList("www.testExample", "www.test2example"))
                .category(new Category("dogs", 1))
                .tags(Arrays.asList(new TagsItem("friendly", 1), new TagsItem("playful", 2)))
                .build();
    }
}
