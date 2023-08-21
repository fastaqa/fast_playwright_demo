package pl.akademiaqa.modul_7;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.nio.file.Paths;

class _4DownloadFileTest extends BaseTest {

    @Test
    void downloadWithHandlerTest() {
        page.navigate("http://localhost:7080/download");

        // HANDLER ZAWSZE PRZEK KLIKNIĘCIEM!
        page.onDownload(download -> download.saveAs(Paths.get("downloads/some-file.txt")));

        // KLIKMAY
        page.getByText("some-file.txt").click();
    }

    @Test
    void downloadWithSaveTest() {
        page.navigate("http://localhost:7080/download");

        // KLIKAMY
        Download download = page.waitForDownload(() -> page.getByText("some-file.txt").click());

        // ZAPISUJEMY
        download.saveAs(Paths.get("downloads/some-file1.txt"));
    }
}
