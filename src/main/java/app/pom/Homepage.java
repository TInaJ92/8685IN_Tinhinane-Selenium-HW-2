package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends SystemBar {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

}
