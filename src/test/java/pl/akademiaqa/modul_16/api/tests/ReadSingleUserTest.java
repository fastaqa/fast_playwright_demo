package pl.akademiaqa.modul_16.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.response.user.GetUserResponse;

import java.io.IOException;

class ReadSingleUserTest extends BaseApiTest {

    @Test
    void should_return_single_user_response_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

//        System.out.println(response.status());
//        System.out.println(response.statusText());
//        System.out.println(response.ok());
//        System.out.println(response.text());
//        System.out.println(new String(response.body(), StandardCharsets.UTF_8));
//        System.out.println(response.headers());
//        System.out.println(response.url());
    }

    @Test
    void should_return_single_user_gson_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        // GSON - zamiana odpowiedzi na JsonObject
        JsonObject jsonResponse = new Gson().fromJson(response.text(), JsonObject.class);
        System.out.println(jsonResponse);
        System.out.println(jsonResponse.get("name"));
        System.out.println(jsonResponse.get("email"));
    }

    @Test
    void should_return_single_user_jackson_test() throws IOException {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        // JACKSON-DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.text());
        System.out.println(jsonNode.toPrettyString());
        System.out.println(jsonNode.get("email"));
    }

    @Test // DESERIALIZACJA
    void should_return_single_user_dto_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        GetUserResponse userResponse = new Gson().fromJson(response.text(), GetUserResponse.class);
        System.out.println(userResponse);
        System.out.println(userResponse.getEmail());
    }
}
