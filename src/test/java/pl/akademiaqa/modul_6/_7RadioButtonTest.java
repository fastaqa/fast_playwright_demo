package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _7RadioButtonTest extends BaseTest {

    @Test
    void radioButtonTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        Locator radio2 = page.locator("input[value=rd2]");
        PlaywrightAssertions.assertThat(radio2).isChecked();

        Locator radio1 = page.locator("input[value=rd1]");
        PlaywrightAssertions.assertThat(radio1).not().isChecked();
        radio1.check();
        PlaywrightAssertions.assertThat(radio1).isChecked();

        PlaywrightAssertions.assertThat(radio2).not().isChecked();
    }
}
