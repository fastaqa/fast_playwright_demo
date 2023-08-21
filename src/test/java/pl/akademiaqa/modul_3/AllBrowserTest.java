package pl.akademiaqa.modul_3;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Paths;

class AllBrowserTest extends BaseTest {

    @Test
    void should_open_supported_browsers_chromium() {
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
    }

    @Test
    void should_open_supported_browsers_firefox() {
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
    }

    @Test
    void should_open_supported_browsers_webkit() {
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/webkit.png")));
    }
}
