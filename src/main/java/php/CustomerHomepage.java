package php;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerHomepage extends BasePage {

    private static final String URL = "https://www.phptravels.net/account/dashboard";

    @FindBy(xpath = "//li[@class='page-active']//a[@href='https://www.phptravels.net/account/dashboard']")
    public WebElement dashboardButton;

    public CustomerHomepage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        PageFactory.initElements(driver, this);
    }

}
