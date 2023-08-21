package pl.akademiaqa.modul_13;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HttpPracticeTest extends BaseTest {

    @Test
    void should_return_redirects_in_status_codes_tests() {
        List<Integer> statusCodes = new ArrayList<>();
        page.onResponse(res -> statusCodes.add(res.status()));
        page.navigate("http://skleptestera.pl/");

        assertThat(statusCodes.stream().allMatch(s -> s == 200)).isFalse();
        assertThat(statusCodes).contains(301);
        assertThat(statusCodes).contains(302);
    }

    @Test
    void should_return_only_status_codes_200_tests() {
        List<Integer> statusCodes = new ArrayList<>();
        page.onResponse(res -> statusCodes.add(res.status()));
        page.navigate("https://skleptestera.pl/index.php");

        assertThat(statusCodes.stream().allMatch(s -> s == 200)).isTrue();
    }
}
