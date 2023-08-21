package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class _8DynamicElementsTest extends BaseTest {

    @Test
    void dynamicElementTest1() {
        page.navigate("http://localhost:7080/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        assertThat(text).isVisible();
    }

    @Test
    void dynamicElementTest2() {
        page.navigate("http://localhost:7080/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        assertThat(text).isVisible();
    }

    @Test
    void dynamicControlsTest1() {
        page.navigate("http://localhost:7080/dynamic_controls");
        assertThat(page.locator("#checkbox")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        assertThat(page.locator("#checkbox")).not().isVisible();
        assertThat(page.getByText("it's gone!")).isVisible();
    }

    @Test
    void dynamicControlsTest2() {
        page.navigate("http://localhost:7080/dynamic_controls");
        assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        assertThat(page.locator("#input-example input[type=text]")).isEnabled();
    }
}
