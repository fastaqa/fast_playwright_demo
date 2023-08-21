package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.util.Arrays;

class _1PageTest extends BaseTest {


    @Test
    void pageTest() {

        page.navigate("http://localhost:7080/");
        page.navigate("http://localhost:7080/", new Page.NavigateOptions().setTimeout(10000)); // 30 sek.
        page.navigate("http://localhost:7080/", new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));

        // 1. DOMCONTENTLOADED - html jest załadowany, ale css i js jeszcze nie
        // 2. LOAD - html, css i js są już załadowane | DOMYŚLNY
        // 3. NETWORKIDLE - stan, w którym nie ma już żadnych dodatkowych requestów przez 500 ms

        page.navigate("http://localhost:7080/", new Page.NavigateOptions().setReferer("https://onet.pl"));

        page.reload();
        page.goBack();
        page.goForward();

        page.click("", new Page.ClickOptions().setClickCount(10));
        page.click("", new Page.ClickOptions().setButton(MouseButton.RIGHT));
        page.click("", new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));
        page.dblclick("");
        page.check("");
        page.uncheck("");

    }
}
