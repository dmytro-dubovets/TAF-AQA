import model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PetTest extends BaseTest {

    @Test
    public void shouldFindPetsByStatus() {
        List<Pet> pets = apiPetService.findPetsByStatus();
        Assertions.assertThat(pets.size() > 0).isTrue();
    }
}
