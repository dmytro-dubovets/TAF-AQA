import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import response.ApiResponse;

public class UserTest extends BaseTest {

    @Test
    public void shouldCreateNewUser() {
        final User user = User.getFakeUser();
        final Long actualUserId = user.getId();
        final ApiResponse apiResponse = apiUserService.createNewUser(user);
        Assertions.assertThat(actualUserId).isEqualTo(Long.parseLong(apiResponse.getMessage()));
    }
}
