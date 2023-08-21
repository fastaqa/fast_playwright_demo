package pl.akademiaqa.modul_16.api.tests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions;
import pl.akademiaqa.modul_16.api.facades.user.CreateUserApiFacade;
import pl.akademiaqa.modul_16.api.payload.user.CreateUserPayload;
import pl.akademiaqa.modul_16.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.modul_16.api.transformers.UserTransformers;

import static org.assertj.core.api.Assertions.*;
import static pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions.*;
import static pl.akademiaqa.modul_16.api.transformers.UserTransformers.*;

class PartialUpdateUser extends BaseApiTest {

    @Test
    void should_update_user_email_test() {
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDto = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - UPDATING EXISTING USER");
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "bartek@akademiaqa.pl");

        APIResponse updateResponse = apiContext.patch("users/" + createUserDto.getId(), RequestOptions.create().setData(userUpdate));
        assert200(updateResponse);

        CreateUpdateUserResponse updateUserDto = createUpdateUserToResponseDto(updateResponse);
        assertThat(updateUserDto.getEmail()).isEqualTo("bartek@akademiaqa.pl");
    }
}
