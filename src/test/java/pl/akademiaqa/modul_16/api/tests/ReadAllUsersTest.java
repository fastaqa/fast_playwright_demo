package pl.akademiaqa.modul_16.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.response.user.GetUserResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ReadAllUsersTest extends BaseApiTest {

    @Test
    void should_return_list_of_users_response_test() {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info(apiResponse.text());
    }

    @Test
    void should_return_list_of_users_gson_test() {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        JsonArray jsonArray = new Gson().fromJson(apiResponse.text(), JsonArray.class);
        log.info(jsonArray.toString());

        List<String> emails = jsonArray.asList()
                .stream()
                .map(el -> el.getAsJsonObject().get("email").getAsString())
                .collect(Collectors.toList());

        log.info("MAILE " + emails);

        Assertions.assertThat(emails).contains("Lucio_Hettinger@annie.ca");
    }

    @Test
    void should_return_list_of_users_jackson_test() throws IOException {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // JACKSON-DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(apiResponse.text());
        log.info("JSON NODE: " + jsonNode);
        log.info("EMAIL PIERWSZEGO UŻYTKOWNIKA:" + jsonNode.get(0).get("email"));
    }

    @Test
    void should_return_list_of_users_dto_test() {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // zamiana odpowiedzi na dto - GSON
        List<GetUserResponse> users = Arrays.asList(new Gson().fromJson(apiResponse.text(), GetUserResponse[].class));
        log.info("USERS DTO: " + users);

        // zamiana odpowiedzi na dto - stream()
        JsonArray jsonArray = new Gson().fromJson(apiResponse.text(), JsonArray.class);
        List<GetUserResponse> usersList = jsonArray.asList()
                .stream()
                .map(el -> new GetUserResponse(
                        el.getAsJsonObject().get("id").getAsInt(),
                        el.getAsJsonObject().get("name").getAsString(),
                        el.getAsJsonObject().get("username").getAsString(),
                        el.getAsJsonObject().get("email").getAsString())
                ).collect(Collectors.toList());

        log.info("USERS DTO FROM STREAM: " + usersList);
    }
}
