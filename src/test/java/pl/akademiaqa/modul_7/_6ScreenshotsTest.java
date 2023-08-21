package pl.akademiaqa.modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Paths;

class _6ScreenshotsTest extends BaseTest {

    @Test
    void screenshotPageTest() {
        page.navigate("http://localhost:7080/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/home.jpeg")));
    }

    @Test
    void screenshotElementTest() {
        page.navigate("http://localhost:7080/login");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.locator("#flash-messages").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/login_error_message.jpeg")));
    }
}
