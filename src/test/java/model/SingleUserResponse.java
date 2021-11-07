package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SingleUserResponse {

    private DataUser data;
    private Support support;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DataUser {

        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Support {

        private String url;
        private String text;

    }
}
