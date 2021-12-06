import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import response.ApiResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.with;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest extends BaseTest {

    private List<Long> userIds;
    private User user;

    @BeforeAll
    public void setUp() {
        userIds = new LinkedList<>();
        user = User.getFakeUser();
    }

    @Test
    public void shouldCreateNewUser() {
        Long actualUserId = user.getId();
        userIds.add(actualUserId);
        ApiResponse apiResponse = apiUserService.createNewUser(user);
        assertThat(actualUserId).isEqualTo(Long.parseLong(apiResponse.getMessage()));
    }

    /*
     * Doesn't return created user by userName
     * */
    @Test
    public void shouldReturnCreatedUserByUserName() {
        String actualUserName = user.getUserName();
        userIds.forEach(id -> {
            with().pollInterval(5, TimeUnit.SECONDS)
                    .await(String.format("No created user with required id: %s", id))
                    .atMost(10, TimeUnit.SECONDS)
                    .until(() -> apiUserService.getUserByName(actualUserName).getId(), expectedUserId -> expectedUserId.equals(id));
        });
    }

    @Test
    public void shouldLoginInTheSystem() {
        ApiResponse apiResponse = apiUserService.login(user);
        assertThat(apiResponse.getCode()).isEqualTo(200);
        assertThat(apiResponse.getMessage()).contains("logged in user");
    }

    /*
     * Doesn't delete created user by userName
     * */
    @AfterAll
    public void tearDown() {
        ApiResponse apiResponse = apiUserService.deleteCreatedUserByUserName(user.getUserName(), user.getPassword());
        assertThat(apiResponse.getCode()).isEqualTo(200);
        assertThat(apiResponse.getMessage()).isEqualTo(user.getUserName());
    }
}
