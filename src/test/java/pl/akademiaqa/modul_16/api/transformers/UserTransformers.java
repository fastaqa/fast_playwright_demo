package pl.akademiaqa.modul_16.api.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.akademiaqa.modul_16.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.modul_16.api.response.user.GetUserResponse;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTransformers {

    public static GetUserResponse readUserToResponseDto(APIResponse apiResponse) {
        return new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
    }

    public static CreateUpdateUserResponse createUpdateUserToResponseDto(APIResponse response) {
        return new Gson().fromJson(response.text(), CreateUpdateUserResponse.class);
    }
}
