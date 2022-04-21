package app;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignInButton() {
        clickOnElement(signInButton);

        return new LoginPage();
    }


}
