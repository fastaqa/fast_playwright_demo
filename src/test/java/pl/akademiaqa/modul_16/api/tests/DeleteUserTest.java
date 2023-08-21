package pl.akademiaqa.modul_16.api.tests;

import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions;
import pl.akademiaqa.modul_16.api.facades.user.CreateUserApiFacade;
import pl.akademiaqa.modul_16.api.payload.user.CreateUserPayload;
import pl.akademiaqa.modul_16.api.response.user.CreateUpdateUserResponse;

import static pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions.*;

class DeleteUserTest extends BaseApiTest {

    @Test
    void should_delete_existing_user_test() {
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDto = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - DELETING EXISTING USER");
        APIResponse apiResponse = apiContext.delete("users/" + createUserDto.getId());
        assert200(apiResponse);

        log.info("STEP 3 - READING DELETED USER");
        APIResponse getUserResponse = apiContext.get("users/" + createUserDto.getId());
        assert404(getUserResponse);
    }
}
