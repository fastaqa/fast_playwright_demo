package pl.akademiaqa.modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _7VideoRecordingTest extends BaseTest {

    @Test
    void videoTest() {
        page.navigate("http://localhost:7080/login");
        page.fill("#username", "demouser");
        page.type("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
