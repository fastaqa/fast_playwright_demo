package pl.akademiaqa.modul_8.pages.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManageMyAccountSectionLocators {

    private final Page page;

    public Locator accountCreatedMessage() {
        return page.getByText("Your account has been created.");
    }

    public Locator myAccountLabel() {
        return page.locator("h1[class=page-heading]");
    }
}
