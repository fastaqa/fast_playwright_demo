package pl.akademiaqa.modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class _13Practice7Test extends BaseTest {

    // Wysłać pusty formularz i zrobić screena z błędu.
    // Utworzyć do tego tracing

    @Test
    void should_show_an_error_when_trying_to_send_empty_form() {
        page.navigate("http://www.automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();

        assertThat(page.getByText("Invalid email address.")).isVisible();

        page.locator("#center_column").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/empty_contact_us_form.png")));
    }

    // Wypełnić i wysłać formularz contact us
    // Utworzyć do tego tracing
    @Test
    void should_fill_and_send_contact_us_form() {
        page.navigate("http://www.automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.selectOption("#id_contact", "Webmaster");
        page.getByLabel("Email address").fill("demo@demo.com");
        page.locator("#id_order").fill("12345");
        page.setInputFiles("#fileUpload", Paths.get("uploads/upload-file.txt"));
        page.locator("#message").fill("This is test message");
        page.locator("#submitMessage").click();

        assertThat(page.getByText("Your message has been successfully sent to our team.")).isVisible();
    }
}
