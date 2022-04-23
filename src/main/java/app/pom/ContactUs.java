package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends SystemBar {

    public ContactUs() {
        PageFactory.initElements(driver, this);
    }
}
