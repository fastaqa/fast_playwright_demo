package pl.akademiaqa.modul_6;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _4DropdownText extends BaseTest {

    @Test
    void dropdownTest() {
        page.navigate("http://localhost:7080/dropdown");
        page.selectOption("#dropdown", "1"); // value
//        page.selectOption("#dropdown", "Option 2"); // wartość
    }

    @Test
    void multiselectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms2", "ms3"});
        page.waitForTimeout(3000);
    }
}
