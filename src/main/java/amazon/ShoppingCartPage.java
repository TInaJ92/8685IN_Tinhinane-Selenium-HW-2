package amazon;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']")
    public WebElement confirmationMessage;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }
}
