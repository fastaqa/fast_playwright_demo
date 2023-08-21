package pl.akademiaqa.modul_6;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TableUser {

    private String firstName;
    private String lastName;
    private String email;
    private String due;
    private String website;
    private Locator action;

    public TableUser(String firstName, String lastName, String email, String due, String website, Locator action) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.due = due;
        this.website = website;
        this.action = action;
    }
}
