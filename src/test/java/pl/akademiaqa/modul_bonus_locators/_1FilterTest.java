package pl.akademiaqa.modul_bonus_locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _1FilterTest extends BaseTest {

    @Test
    void filter_text_1_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("Clothes"))
                .click();

        page.waitForTimeout(1000);
    }

    @Test
    void filter_text_2_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator(".js-product")
                .filter(new Locator.FilterOptions().setHasText("Mug Today is a good day"))
                .click();

        page.waitForTimeout(1000);
    }
}
