package pl.akademiaqa.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _3CssLayoutTest extends BaseTest {

    @Test
    void css_right_of_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("input:right-of(div.js-top-menu :text(\"Art\"))").first().fill("TEST TEST");


        page.waitForTimeout(100);
    }
}
