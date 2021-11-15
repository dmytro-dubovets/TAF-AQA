package model;

import lombok.Data;
import lombok.experimental.Accessors;
import util.FakeDataGenerator;

@Data
@Accessors(chain = true)
public class User {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private Integer userStatus;

    public static User getFakeUser() {
        return new FakeDataGenerator().getFakeUser();
    }

}
