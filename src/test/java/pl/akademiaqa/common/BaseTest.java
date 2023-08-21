package pl.akademiaqa.common;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RecordVideoSize;
import org.junit.jupiter.api.*;
import pl.akademiaqa.utils.StringUtils;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;

    private BrowserContext context;
    protected Page page;

    @BeforeAll
    static void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEachBase() {
        context = browser.newContext();

//        BASIC AUTH
//        context = browser.newContext(new Browser.NewContextOptions()
//                .setHttpCredentials("admin", "admin"));

//        START TRACING
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );

//        NAGRYWANIE WIDEO Z TESTU
//        context = browser.newContext(new Browser.NewContextOptions()
//                .setViewportSize(1920, 1080)
//                .setRecordVideoDir(Paths.get("videos/"))
//                .setRecordVideoSize(new RecordVideoSize(1920, 1080)));


        page = context.newPage();
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {

        String traceName = "traces/trace_"
                + StringUtils.removeRoundBrackets(testInfo.getDisplayName())
                + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip";

        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        context.close();
    }

    @AfterAll
    static void afterAll() {
        pw.close();
    }
}
