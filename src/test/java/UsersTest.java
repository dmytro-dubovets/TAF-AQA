import io.restassured.response.Response;
import model.SingleUserResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.ResponseStatus.SUCCESS;

public class UsersTest extends BaseTest {

    @Test
    public void getAllUsers() {
        Response response = apiService.getAllUsers();
        assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(SUCCESS.getStatus()));
    }

    @Test
    public void getSingleUser() {
        int userId = 1;
        Response response = apiService.getSingleUser(userId);
        SingleUserResponse singleUserResponse = response.as(SingleUserResponse.class);
        assertThat(singleUserResponse.getData().getId()).isEqualTo(userId);
        assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(SUCCESS.getStatus()));
    }
}
