package util;

import com.github.javafaker.Faker;
import lombok.Getter;
import model.Pet;
import model.User;

import java.util.Locale;

@Getter
public class FakeUserDataGenerator {

    private final Faker faker = new Faker(new Locale("en-Us"));
    private final String requiredUserTestName = SystemProperties.getInstance().getProperty("USER_TEST_NAME");
    private final Long id = faker.number().randomNumber(10, false);
    private final String userName = requiredUserTestName + faker.name().username();
    private final String firsName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password();
    private final String phone = faker.phoneNumber().cellPhone();
    private final Integer userStatus = faker.number().randomDigitNotZero();

    public User getFakeUser() {
        return User.builder().id(getId())
                .userName(getUserName())
                .firstName(getFirsName())
                .lastName(getLastName())
                .email(getEmail())
                .password(getPassword())
                .phone(getPhone())
                .userStatus(getUserStatus())
                .build();
    }

}
