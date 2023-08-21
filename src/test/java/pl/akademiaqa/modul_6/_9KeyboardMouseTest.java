package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class _9KeyboardMouseTest extends BaseTest {

    @Test
    void keyboardTest() {
        page.navigate("http://localhost:7080/key_presses");
        page.locator("#target").click();
        Keyboard keyboard = page.keyboard();
        keyboard.press("ArrowUp");
        assertThat(page.getByText("You entered: UP")).isVisible();
    }

    @Test
    void mouseTest() {
        page.navigate("http://localhost:7080/context_menu");
        Mouse mouse = page.mouse();

        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });

        mouse.click(250, 250, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
    }

    @Test
    void dragAndDropTest() {
        page.navigate("http://localhost:7080/drag_and_drop");
        Locator el1 = page.locator("#column-a");
        Locator el2 = page.locator("#column-b");

        el1.dragTo(el2);
    }
}
