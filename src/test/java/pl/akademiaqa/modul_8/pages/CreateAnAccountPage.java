package pl.akademiaqa.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.modul_8.pages.sections.CreateAnAccountFormSection;

@Getter
public class CreateAnAccountPage extends BasePage {

    private CreateAnAccountFormSection createAnAccountFormSection;

    public CreateAnAccountPage(Page page) {
        super(page);
        this.createAnAccountFormSection = new CreateAnAccountFormSection(page);
    }
}
