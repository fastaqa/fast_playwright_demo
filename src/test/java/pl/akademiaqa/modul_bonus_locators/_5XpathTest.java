package pl.akademiaqa.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _5XpathTest extends BaseTest {

    @Test
    void xpath_basic_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//input[@name='s']").fill("xpath");

        page.waitForTimeout(1000);
    }

    @Test
    void xpath_contains_text_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//a[contains(text(), 'Art')]").click();

        page.waitForTimeout(1000);
    }

    @Test
    void xpath_and_or_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//li[@class='category' and @id='category-9']").click();

        page.waitForTimeout(1000);
    }

    @Test
    void xpath_starts_with_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//li[starts-with(@class, 'cat') and @id='category-9']").click();

        page.waitForTimeout(1000);
    }

    @Test
    void xpath_text_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//span[text()='Zaloguj się']").click();

        page.waitForTimeout(1000);
    }
}
