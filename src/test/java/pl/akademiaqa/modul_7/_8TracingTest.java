package pl.akademiaqa.modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _8TracingTest extends BaseTest {

    // DOC - https://playwright.dev/java/docs/trace-viewer-intro
    // https://trace.playwright.dev/
    // TERMINAL - mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace traces/trace.zip"

    @Test
    void traceDemoTest() {
        page.navigate("http://localhost:7080/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "tomaszkowalski");
        page.type("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
