package amazon;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ItemListingPage extends BasePage {

    @FindBy(id = "quantity")
    public WebElement quantityComboBox;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='attachSiNoCoverage']//input")
    public WebElement warrantyPaneNoThanksButton;

    public ItemListingPage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage selectQuantityAddItemToCart(String quantity) {
        selectQuantityByVisibleText(quantity);
        clickAddToCartButton();

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(warrantyPaneNoThanksButton));
            warrantyPaneNoThanksButton.click();
        } catch (NoSuchElementException nse) {

        }
        webDriverWait.until(ExpectedConditions.titleIs("Amazon.com Shopping Cart"));
        return new ShoppingCartPage();
    }

    public void selectQuantityByVisibleText(String text) {
        Select select = new Select(quantityComboBox);
        select.selectByVisibleText(text);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }


}
