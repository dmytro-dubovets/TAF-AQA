package util;

import com.github.javafaker.Faker;
import model.User;

import java.util.Locale;

public class FakeDataGenerator {

    private final Faker faker = new Faker(new Locale("en-Us"));

    private final Long id = faker.number().randomNumber(10, false);
    private final String userName = faker.name().username();
    private final String firsName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password();
    private final String phone = faker.phoneNumber().cellPhone();
    private final Integer userStatus = faker.number().randomDigitNotZero();

    public User getFakeUser() {
        return new User().setId(getId())
                .setUserName(getUserName())
                .setFirstName(getFirsName())
                .setLastName(getLastName())
                .setEmail(getEmail())
                .setPassword(getPassword())
                .setPhone(getPhone())
                .setUserStatus(getUserStatus());
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

}
