import service.ApiPetService;
import service.ApiUserService;
import util.SystemProperties;

public abstract class BaseTest {

    ApiPetService apiPetService = new ApiPetService(SystemProperties.APPLICATION_URL);
    ApiUserService apiUserService = new ApiUserService(SystemProperties.APPLICATION_URL);

}
