package pl.akademiaqa.modul_16.api.tests;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions;
import pl.akademiaqa.modul_16.api.facades.user.CreateUserApiFacade;
import pl.akademiaqa.modul_16.api.payload.user.CreateUserAddressPayload;
import pl.akademiaqa.modul_16.api.payload.user.CreateUserPayload;
import pl.akademiaqa.modul_16.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.modul_16.api.response.user.GetUserResponse;
import pl.akademiaqa.modul_16.api.transformers.UserTransformers;

import static pl.akademiaqa.modul_16.api.assertions.StatusCodeAssertions.*;
import static pl.akademiaqa.modul_16.api.transformers.UserTransformers.*;

class UpdateUserTest extends BaseApiTest {

    @Test
    void should_update_entire_user_test() {
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDto = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - UPDATING EXISTING USER");
        user.setEmail("bartek@akademiaqa.pl");

        APIResponse updateUserResponse = apiContext.put("users/" + createUserDto.getId(), RequestOptions.create().setData(user));
        assert200(updateUserResponse);

        CreateUpdateUserResponse updateUserResponseDTO = createUpdateUserToResponseDto(updateUserResponse);
        Assertions.assertThat(updateUserResponseDTO.getEmail()).isEqualTo("bartek@akademiaqa.pl");
        log.info("Updated user: " + updateUserResponseDTO);

        log.info("STEP 3 - READING UPDATED USER");
        APIResponse apiResponse = apiContext.get("users/" + createUserDto.getId());
        assert200(updateUserResponse);

        GetUserResponse getUserResponseDTO = readUserToResponseDto(apiResponse);
        Assertions.assertThat(getUserResponseDTO.getEmail()).isEqualTo("bartek@akademiaqa.pl");
        log.info("Read user: " + getUserResponseDTO);
    }
}
