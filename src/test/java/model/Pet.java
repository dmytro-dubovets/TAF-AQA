package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Status;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    private Long id;
    private Category category;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;

    @Data
    public static class Category {

        private Long id;
        private String name;
    }

    @Data
    public static class Tag {

        private Integer id;
        private String name;
    }
}
