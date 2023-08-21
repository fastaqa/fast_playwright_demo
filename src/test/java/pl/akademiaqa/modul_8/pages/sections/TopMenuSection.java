package pl.akademiaqa.modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.modul_8.pages.BasePage;
import pl.akademiaqa.modul_8.pages.ContactUsPage;
import pl.akademiaqa.modul_8.pages.CreateAnAccountPage;

public class TopMenuSection extends BasePage {

    private Locator contactUsLink;
    private Locator signInLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
        signInLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in"));
    }

    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }

    public CreateAnAccountPage clickSignInLink() {
        signInLink.click();
        return new CreateAnAccountPage(page);
    }
}
