package php;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerLoginPage extends BasePage {

    static final String URL = "https://www.phptravels.net/login";

    @FindBy (xpath = "//input[@type='email'][@placeholder='Email']")
    public WebElement emailInputField;

    @FindBy (xpath = "//input[@type='password'][@placeholder='Password']")
    public WebElement passwordInputField;

    @FindBy (xpath = "//div[@class='btn-box pt-3 pb-4']//button[@type='submit']")
    public WebElement loginButton;

    public CustomerLoginPage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        PageFactory.initElements(driver, this);
    }

    public CustomerHomepage login(String emailAddress, String password) {
        inputEmailAddress(emailAddress);
        inputPassword(password);
        clickLoginButton();

        return new CustomerHomepage();
    }

    public void inputEmailAddress(String emailAddress) {
        sendKeysToElement(emailInputField, emailAddress);
    }

    public void inputPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }
}
