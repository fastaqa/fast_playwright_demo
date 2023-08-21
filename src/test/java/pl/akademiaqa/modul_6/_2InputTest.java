package pl.akademiaqa.modul_6;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _2InputTest extends BaseTest {

    @Test
    void inputTest() {
        page.navigate("http://localhost:7080/login");
        page.fill("#username", "bartek"); // wkleja cały text
        page.type("#password", "123456"); // wpisuje text znak po znaku

//        page.fill("", "wartość", new Page.FillOptions().setForce(true));
    }
}
