package pojo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewPetRequest {
    private List<String> photoUrls;
    private String name;
    private int id;
    private Category category;
    private List<TagsItem> tags;
    private String status;
}