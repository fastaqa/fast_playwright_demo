package pl.akademiaqa.modul_7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class _11StorageStateTest {

    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void should_save_storage_state_after_login_test() {
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.locator("#passwd").fill("123456");
        page.locator("#SubmitLogin").click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("storage/aplogin.json")));
    }

    @Test
    void should_load_storage_state_test() {
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("storage/aplogin.json")));
        Page page = browserContext.newPage();

        page.navigate("http://automationpractice.pl/index.php?controller=my-account");
        PlaywrightAssertions.assertThat(page.locator("h1[class=page-heading]")).hasText("My account");
        page.waitForTimeout(3000);
    }
}
