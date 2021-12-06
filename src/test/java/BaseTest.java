import service.ApiPetService;
import service.ApiUserService;
import util.SystemProperties;

public abstract class BaseTest {

    ApiPetService apiPetService = new ApiPetService(SystemProperties.getInstance().getProperty("BASE_URL"));
    ApiUserService apiUserService = new ApiUserService(SystemProperties.getInstance().getProperty("BASE_URL"));

}
