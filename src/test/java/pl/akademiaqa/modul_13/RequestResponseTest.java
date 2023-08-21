package pl.akademiaqa.modul_13;

import com.microsoft.playwright.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;


class RequestResponseTest extends BaseTest {

    @Test
    void should_return_status_code_200_ok_test() {
        Response response = page.navigate("http://skleptestera.pl");

        // STATUS CODE
        // System.out.println(response.status());
        // System.out.println(response.ok());

        // BODY
        // System.out.println(new String(response.body(), StandardCharsets.UTF_8));
        // System.out.println(response.text());

        // HEADERS
        // System.out.println(response.headers());
        //System.out.println(response.headers().get("content-type"));

        // URL
        // System.out.println(response.url());

        assertThat(response.ok()).isTrue();
    }


    @Test
    void should_return_request_method_get_test() {
        Response response = page.navigate("http://skleptestera.pl");

        System.out.println(response.request().method());
        System.out.println(response.request().postData());
        System.out.println(response.request().headers());

        assertThat(response.request().method()).isEqualTo("GET");
    }

    @Test
    void http_handlers_test() {
        page.onRequest(req -> System.out.println(">> " + req.method() + " " + req.url()));
        page.onResponse(res -> System.out.println("<< " + res.status()));
        page.navigate("https://skleptestera.pl/index.php");
    }
}
