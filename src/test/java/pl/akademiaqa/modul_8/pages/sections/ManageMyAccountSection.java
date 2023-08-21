package pl.akademiaqa.modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.modul_8.pages.BasePage;
import pl.akademiaqa.modul_8.pages.locators.ManageMyAccountSectionLocators;

@Getter
public class ManageMyAccountSection extends BasePage {

    private ManageMyAccountSectionLocators locators;

    public ManageMyAccountSection(Page page) {
        super(page);
        this.locators = new ManageMyAccountSectionLocators(page);
    }
}
