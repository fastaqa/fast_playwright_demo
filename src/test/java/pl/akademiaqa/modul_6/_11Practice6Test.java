package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class _11Practice6Test extends BaseTest {

    @Test
    void should_verify_all_product_prices_are_above_15_usd() {
        List<Product> products = getProducts();
        List<Integer> prices = new ArrayList<>();
        products.forEach(p -> prices.add(p.getPrices()));
        assertThat(prices.stream().allMatch(p -> p > 15)).isTrue();
    }

    @Test
    void should_verify_all_product_names_contains_printed() {
        List<Product> products = getProducts();
        List<String> names = new ArrayList<>();
        products.forEach(p -> names.add(p.getName()));
        assertThat(names.stream().allMatch(n -> n.contains("Printed"))).isTrue();
    }

    private List<Product> getProducts(){
        page.navigate("http://www.automationpractice.pl/");
        Locator topMenuBlock = page.locator("#block_top_menu");
        topMenuBlock.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DRESSES"))).click();

        List<Locator> productLocators = page.locator(".product_list .ajax_block_product").all();

        List<Product> products = new ArrayList<>();

        productLocators.forEach(p -> {
            Integer price = Integer.valueOf(p.locator(".right-block .content_price .price ").innerText().replace("$", ""));
            String name = p.locator(".right-block .product-name").innerText();

            products.add(new Product(name, price));
        });

        return products;
    }
}
