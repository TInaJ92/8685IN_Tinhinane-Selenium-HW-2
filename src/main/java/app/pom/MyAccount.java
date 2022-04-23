package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends SystemBar {

    @FindBy(xpath = "//a[@class='account']")
    public WebElement myAccountButton;

    public final String URL = "http://automationpractice.com/index.php?controller=my-account";

    public MyAccount() {
        PageFactory.initElements(driver, this);
    }

}
