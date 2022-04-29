package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends SystemBar {

    public MyAccount() {
        PageFactory.initElements(driver, this);
    }

}
