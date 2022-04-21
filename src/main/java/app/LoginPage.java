package app;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email")
    public WebElement emailAddressInputField;

    @FindBy(id = "passwd")
    public WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='center_column']/div[@class='alert alert-danger']")
    public WebElement errorMessageBanner;

    @FindBy(xpath = "//div[@id='center_column']//div[@class='alert alert-danger']//li")
    public WebElement errorMessageText;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAddress(String emailAddress) {
        sendKeysToElement(emailAddressInputField, emailAddress);
    }

    public void enterPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    public void clickSignInButton() {
        clickOnElement(signInButton);
    }

    public void login(String emailAddress, String password) {
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickSignInButton();
    }
}
