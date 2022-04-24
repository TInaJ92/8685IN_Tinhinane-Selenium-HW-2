package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends SystemBar {

    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email_create")
    public WebElement newEmailAddressInputField;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(id = "email")
    public WebElement registeredEmailAddressInputField;

    @FindBy(xpath = "//div[@class='form-group form-error']")
    public WebElement invalidEmailInputField;

    @FindBy(xpath = "//div[@class='form-group form-ok']")
    public WebElement validEmailInputField;

    @FindBy(id = "passwd")
    public WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='center_column']/div[@class='alert alert-danger']")
    public WebElement errorMessageBanner;

    @FindBy(xpath = "//div[@id='center_column']//div[@class='alert alert-danger']//li")
    public WebElement errorMessageText;

    public Login() {
        PageFactory.initElements(driver, this);
    }

    // region Create Account
    public CreateAccount createAccount(String emailAddress) {
        inputNewEmailAddress(emailAddress);
        return clickCreateAccountButton();
    }

    public void inputNewEmailAddress(String emailAddress) {
        sendKeysToElement(newEmailAddressInputField, emailAddress);
    }

    public CreateAccount clickCreateAccountButton() {
        clickOnElement(createAccountButton);
        return new CreateAccount();
    }

    // endregion

    // region Login
    public MyAccount login(String emailAddress, String password) {
        inputRegisteredEmailAddress(emailAddress);
        inputPassword(password);
        clickSignInButton();

        return new MyAccount();
    }

    public void inputRegisteredEmailAddress(String emailAddress) {
        sendKeysToElement(registeredEmailAddressInputField, emailAddress);
    }

    public void inputPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    public void clickSignInButton() {
        clickOnElement(signInButton);
    }

    // endregion

}
