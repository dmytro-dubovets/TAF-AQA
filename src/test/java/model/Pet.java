package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
