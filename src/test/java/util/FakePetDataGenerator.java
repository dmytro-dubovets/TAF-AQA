package util;

import com.github.javafaker.Faker;
import enums.Status;
import lombok.Getter;
import model.Pet;
import model.User;

import java.util.Locale;

@Getter
public class FakePetDataGenerator {

    private final Faker faker = new Faker(new Locale("en-Us"));
    private final String requiredPetTestName = SystemProperties.getInstance().getProperty("PET_TEST_NAME");
    private final Long categoryId = faker.number().randomNumber(10, false);
    private final String category = faker.cat().breed();
    private final String name = faker.cat().name();
    private final String photoUrls = faker.internet().url();
    private final String tagsName = faker.animal().name();
    private final String status = Status.AVAILABLE.getValue();

    public Pet getFakePet() {
        return Pet.builder().id(getCategoryId())
                .build();
    }

}
