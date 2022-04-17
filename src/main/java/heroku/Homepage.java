package heroku;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(xpath = "//a[@href='/checkboxes']")
    public WebElement checkBoxButton;

    @FindBy(xpath = "//a[@href='/dropdown']")
    public WebElement dropdownButton;

    @FindBy(xpath = "//a[@href='/drag_and_drop']")
    public WebElement dragDropButton;

    @FindBy(xpath = "//a[@href='/basic_auth']")
    public WebElement basicAuthButton;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public CheckBoxPage navigateToCheckBoxPage() {
        clickOnElement(checkBoxButton);

        return new CheckBoxPage();
    }

    public DropdownPage navigateToDropdownPage() {
        clickOnElement(dropdownButton);

        return new DropdownPage();
    }

    public DragDropPage navigateToDragDropPage() {
        clickOnElement(dragDropButton);

        return new DragDropPage();
    }

    public BasicAuthPage navigateToBasicAuthPage() {
        clickOnElement(basicAuthButton);

        return new BasicAuthPage();
    }
}
