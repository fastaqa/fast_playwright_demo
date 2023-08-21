package pl.akademiaqa.modul_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _3DialogTest extends BaseTest {

    @Test
    void dialogAlertTest() { // OK
        page.navigate("http://localhost:7080/javascript_alerts");

        // HANDLER ZAWSZE PRZED KLIKNIĘCIEM!
        page.onDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });

        page.locator("text=Click for JS Alert").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfuly clicked an alert");
    }

    @Test
    void dialogConfirmTest() { // CANCEL/ANULIJ
        page.navigate("http://localhost:7080/javascript_alerts");

        // HANDLER ZAWSZE PRZED KLIKNIĘCIEM!
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        // HANDLER ZAWSZE PRZED KLIKNIĘCIEM!
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.dismiss();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() { // CANCEL/ANULIJ
        page.navigate("http://localhost:7080/javascript_alerts");

        // HANDLER ZAWSZE PRZED KLIKNIĘCIEM!
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept("123");
        });

        page.locator("text=Click for JS Prompt").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: 123");
    }
}
