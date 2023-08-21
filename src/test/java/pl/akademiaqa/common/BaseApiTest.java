package pl.akademiaqa.common;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseApiTest {

    protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseApiTest.class);

    private Playwright playwright;
    private APIRequest request;
    protected APIRequestContext apiContext;

    @BeforeAll
    void beforeAllApi() {
        playwright = Playwright.create();
        request = playwright.request();
    }

    @BeforeEach
    void beforeEachApi() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        apiContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:3000/")
                .setExtraHTTPHeaders(headers));
    }

    @AfterAll
    void afterAllApi() {
        playwright.close();
    }
}
