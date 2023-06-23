package loginpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign In')]")
    public WebElement loginLink;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//input[@name='login[password]']")
    public WebElement inputPassword ;
    @FindBy(xpath = "//button[@class='action login primary']/span[.='Sign In']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
    public WebElement resultLoginMessage;






    public void clickLoginLink() {
        safeClickOnElement(loginLink);
    }
    public void setInputEmail(String validEmail){
        sendKeysToElement(inputEmail, validEmail);
    }
    public void setInputPassword(String validPassword){
        sendKeysToElement(inputPassword, validPassword);
    }
    public void clickLoginButton() {
        safeClickOnElement(loginButton);
    }
    public void getLogIn(String validEmail, String validPassword){
        clickLoginLink();
        setInputEmail(validEmail);
        setInputPassword(validPassword);
        clickLoginButton();

    }

}
