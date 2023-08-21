package pl.akademiaqa.modul_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class Practice4Test extends BaseTest {

    @Test
    void should_show_error_when_login_with_empty_form() {
        page.navigate("http://localhost:7080/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }

    @Test
    void should_show_error_when_login_with_invalid_username() {
        page.navigate("http://localhost:7080/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByLabel("Username").fill("tomsmith123");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }

    @Test
    void should_show_error_when_login_with_invalid_password() {
        page.navigate("http://localhost:7080/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
    }
}
