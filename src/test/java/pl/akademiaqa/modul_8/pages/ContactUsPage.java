package pl.akademiaqa.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.modul_8.pages.sections.ContactUsFormSection;

public class ContactUsPage extends BasePage {

    @Getter
    private ContactUsFormSection contactUsFormSection;

    public ContactUsPage(Page page) {
        super(page);
        this.contactUsFormSection = new ContactUsFormSection(page);
    }
}
