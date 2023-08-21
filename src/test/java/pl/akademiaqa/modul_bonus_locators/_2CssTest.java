package pl.akademiaqa.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;
class _2CssTest extends BaseTest {

    @Test
    void css_by_has_text_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("div.js-top-menu a:has-text(\"Art\")").click();

        page.waitForTimeout(1000);
    }

    @Test
    void css_by_text_test(){
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("div.js-top-menu :text(\"Art\")").click();

        page.waitForTimeout(2000);
    }

    @Test
    void css_by_text_is_test(){
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("div.js-top-menu :text-is(\"Produkty powiązane\")").click();

        page.waitForTimeout(2000);
    }

    @Test
    void css_containing_other_elements_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("li.category:has(a:has-text(\"Art\"))").click();

        page.waitForTimeout(1000);
    }
}
