package pl.akademiaqa.modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.modul_8.pages.BasePage;
import pl.akademiaqa.modul_8.pages.MyAccountPage;

public class CreateAnAccountFormSection extends BasePage {

    private Locator emailInput;
    private Locator createAnAccountButton;
    private Locator createAnAccountForm1;
    private Locator createAnAccountForm2;
    private Locator genderMr;
    private Locator genderMrs;
    private Locator firstName;
    private Locator lastName;
    private Locator password;
    private Locator dobDay;
    private Locator dobMonth;
    private Locator dobYear;
    private Locator registerButton;

    public CreateAnAccountFormSection(Page page) {
        super(page);
        this.emailInput = page.locator("#email_create");
        this.createAnAccountButton = page.locator("#SubmitCreate");
        this.createAnAccountForm1 = page.locator("#create-account_form");
        this.createAnAccountForm2 = page.locator("#account-creation_form");
        this.genderMr = page.locator("#uniform-id_gender1");
        this.genderMrs = page.locator("#uniform-id_gender2");
        this.firstName = page.locator("#customer_firstname");
        this.lastName = page.locator("#customer_lastname");
        this.password = page.locator("#passwd");
        this.dobDay = page.locator("#days");
        this.dobMonth = page.locator("#months");
        this.dobYear = page.locator("#years");
        this.registerButton = page.locator("#submitAccount");
    }

    public CreateAnAccountFormSection enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    public CreateAnAccountFormSection clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return this;
    }

    public CreateAnAccountFormSection checkGenderMr() {
        genderMr.check();
        return this;
    }

    public CreateAnAccountFormSection checkGenderMrs() {
        genderMrs.check();
        return this;

    }

    public CreateAnAccountFormSection enterFirstName(String firstNameText) {
        firstName.fill(firstNameText);
        return this;
    }

    public CreateAnAccountFormSection enterLastName(String lastNameText) {
        lastName.fill(lastNameText);
        return this;
    }

    public CreateAnAccountFormSection enterPassword(String passwordText) {
        password.fill(passwordText);
        return this;
    }

    public CreateAnAccountFormSection setDateOfBirth(String day, String month, String year) {
        dobDay.selectOption(day);
        dobMonth.selectOption(month);
        dobYear.selectOption(year);
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        registerButton.click();
        return new MyAccountPage(page);
    }

}
