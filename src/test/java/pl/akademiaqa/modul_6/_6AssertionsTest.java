package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;
class _6AssertionsTest extends BaseTest {

    // https://playwright.dev/java/docs/test-assertions

    @Test
    void assertionsTest() {
        page.navigate("http://localhost:7080/checkboxes");

        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();
        firstCheckbox.check();
        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();
    }
}
