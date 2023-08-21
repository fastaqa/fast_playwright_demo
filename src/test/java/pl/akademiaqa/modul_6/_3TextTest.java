package pl.akademiaqa.modul_6;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _3TextTest extends BaseTest {

    @Test
    void textTest() {
        page.navigate("http://localhost:7080/notification_message_rendered");

        // 1 .innerHTML() - tags + text
        // System.out.println(page.innerHTML("#content"));

        // 2 .innerText() - sam text (text widoczny dla człowieka)
        // System.out.println(page.innerText("#content"));

        // 3 .textContent() - sam text, widoczny i niewidoczny (np: <span display:none>hidden)
        // System.out.println(page.textContent("#content"));

        // 4 .getAttribute() - atrybuty elementów html
        // System.out.println(page.getAttribute("div img", "alt"));
    }
}
