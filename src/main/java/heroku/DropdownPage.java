package heroku;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropdownPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/dropdown";

    @FindBy(id = "dropdown")
    public WebElement dropdown;

    @FindBy(xpath = "//select[@id='dropdown']//option[@value='1']")
    public WebElement dropdownOptionOne;

    @FindBy(xpath = "//select[@id='dropdown']//option[@value='2']")
    public WebElement dropdownOptionTwo;

    public DropdownPage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        PageFactory.initElements(driver, this);
    }

    public void selectDropdownOption(String visibleText) {
        selectFromDropdownByVisibleText(dropdown, visibleText);
    }

}
