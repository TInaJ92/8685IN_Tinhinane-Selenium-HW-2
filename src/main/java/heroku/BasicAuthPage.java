package heroku;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasicAuthPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/basic_auth";
    Alert alert;

    public BasicAuthPage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        alert = driver.switchTo().alert();
        PageFactory.initElements(driver, this);
    }

    public void login() {
    }
}
