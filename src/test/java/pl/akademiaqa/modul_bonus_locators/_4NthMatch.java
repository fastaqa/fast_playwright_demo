package pl.akademiaqa.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _4NthMatch extends BaseTest {

    @Test
    void css_nth_match_test() {
        page.navigate("https://skleptestera.pl/index.php");

//        page.locator("input:visible").fill("TEST TEST");

        page.locator(":nth-match(input:visible, 1)").fill("TEST TEST");
        page.waitForTimeout(1000);
    }

    @Test
    void css_nth_element_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("input:visible").locator("nth=0").fill("TEST TEST");

        page.waitForTimeout(1000);
    }
}
