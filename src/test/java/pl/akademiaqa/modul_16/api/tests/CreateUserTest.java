package pl.akademiaqa.modul_16.api.tests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.modul_16.api.payload.user.CreateUserPayload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

class CreateUserTest extends BaseApiTest {

    @Test
    void should_create_new_user_from_text_payload_test() {

        String payload = """
                {
                  "name": "Json Text",
                  "username": "json.text",
                  "email": "Rey.Padberg@karina.biz",
                  "address": {
                    "street": "Kattie Turnpike",
                    "suite": "Suite 198",
                    "city": "Lebsackbury",
                    "zipcode": "31428-2261",
                    "geo": {
                      "lat": "-38.2386",
                      "lng": "57.2232"
                    }
                  },
                  "phone": "024-648-3804",
                  "website": "ambrose.net",
                  "company": {
                    "name": "Hoeger LLC",
                    "catchPhrase": "Centralized empowering task-force",
                    "bs": "target end-to-end models"
                  }
                }
                """;

        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(payload));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_map_payload_test() {

        // GEO
        Map<String, Object> geo = new HashMap<>();
        geo.put("lat", "-37.3159");
        geo.put("lng", "81.1496");

        // ADDRESS
        Map<String, Object> address = new HashMap<>();
        address.put("street", "Kulas Light");
        address.put("suite", "Apt. 556");
        address.put("city", "Gwenborough");
        address.put("zipcode", "92998-3874");
        address.put("geo", geo);

        // COMPANY
        Map<String, Object> company = new HashMap<>();
        company.put("name", "Romaguera-Crona");
        company.put("catchPhrase", "Multi-layered client-server neural-net");
        company.put("bs", "harness real-time e-markets");

        // USER
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Json Map");
        user.put("username", "json.map");
        user.put("email", "Sincere@april.biz");
        user.put("address", address);
        user.put("phone", "1-770-736-8031 x56442");
        user.put("website", "hildegard.org");
        user.put("company", company);


        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_json_object_payload_test() {

        // GEO
        JsonObject geo = new JsonObject();
        geo.addProperty("lat", "-37.3159");
        geo.addProperty("lng", "81.1496");

        // ADDRESS
        JsonObject address = new JsonObject();
        address.addProperty("street", "Kulas Light");
        address.addProperty("suite", "Apt. 556");
        address.addProperty("city", "Gwenborough");
        address.addProperty("zipcode", "92998-3874");
        address.add("geo", geo);

        // COMPANY
        JsonObject company = new JsonObject();
        company.addProperty("name", "Romaguera-Crona");
        company.addProperty("catchPhrase", "Multi-layered client-server neural-net");
        company.addProperty("bs", "harness real-time e-markets");

        // USER
        JsonObject user = new JsonObject();
        user.addProperty("name", "Json Object");
        user.addProperty("username", "json.object");
        user.addProperty("email", "Sincere@april.biz");
        user.add("address", address);
        user.addProperty("phone", "1-770-736-8031 x56442");
        user.addProperty("website", "hildegard.org");
        user.add("company", company);


        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_file_payload_test() throws IOException {
        byte[] user = Files.readAllBytes(Path.of("src/main/resources/json/user.json"));

        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_dto_payload_test() {

        CreateUserPayload user = CreateUserPayload.createDefaultPayload();

        // serializacja - obiekt na json
        APIResponse response = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(response).isOK();

        System.out.println(response.text());
    }

//    private byte[] getPayloadFromFile(String fileName) throws IOException {
//        return Files.readAllBytes(Path.of(Properties.getProperty("app.json.file.path") + fileName));
//    }
}
