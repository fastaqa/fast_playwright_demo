package pl.akademiaqa.modul_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

class _1IFrameTest extends BaseTest {

    @Test
    void should_enter_text_into_the_iframe() {
        page.navigate("http://localhost:7080/iframe");
        // Jeżeli nie na mazwy to używamy frameLocator
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("DEMO");
    }

    @Test
    void should_get_text_from_nested_frames() {
        page.navigate("http://localhost:7080/nested_frames");
        // Jeżeli jest nazwa/name to używamy page.frame
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
