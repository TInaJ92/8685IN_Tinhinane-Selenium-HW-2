package app.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Products extends SystemBar {

    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    public WebElement iFrameQuickViewShoppingCart;

    @FindBy(id = "quantity_wanted")
    public WebElement quantityField;

    @FindBy(id = "group_1")
    public WebElement sizeComboBox;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li[contains(@class,'selected')]/a")
    public WebElement selectedColor;

    @FindBy(xpath = "//p//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@id='layer_cart'][contains(@style, 'display: block;')]")
    public WebElement modalShoppingCart;

    @FindBy(xpath = "//div[contains(@class, 'layer_cart_product')]//h2")
    public WebElement modalShoppingCartSuccessOrFailMessage;

    @FindBy(xpath = "//div[@id='layer_cart']//span[@class='ajax_cart_quantity']")
    public WebElement modalShoppingCartQuantityCount;

    public Products() {
        PageFactory.initElements(driver, this);
    }

    public void switchToShoppingCartQuickViewFrame() {
        switchToFrameByElement(iFrameQuickViewShoppingCart);
    }

    public void setProductQuantity(int quantity) {
        clearSendKeysToElement(quantityField, String.valueOf(quantity));
    }

    public void selectProductSize(String size) {
        if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")) {
            selectFromDropdownByVisibleText(sizeComboBox, size.toUpperCase());
        }
    }

    public String getSelectedColor() {
        return selectedColor.getAttribute("title").trim();
    }

    public List<WebElement> getUnselectedColors(){
        return driver.findElements(By.xpath("//ul[@id='color_to_pick_list']/li[not(contains(@class,'selected'))]/a"));
    }

    public void setColorAtRandom() {
        List<WebElement> unselectedColors = getUnselectedColors();
        if (unselectedColors.size() == 1) {
            clickOnElement(unselectedColors.get(0));
        } else {
            Random random = new Random();
            int index = random.nextInt(unselectedColors.size() - 1);
            clickOnElement(unselectedColors.get(index));
        }
    }

    public void clickSubmitButton() {
        safeClickOnElement(submitButton);
    }

    public void addItemToCart(int quantity, String size) {
        switchToShoppingCartQuickViewFrame();
        setProductQuantity(quantity);
        selectProductSize(size);

        System.out.printf("SELECTED COLOR: %s%n", getSelectedColor());

        setColorAtRandom();
        clickSubmitButton();
        switchToParentFrame();
    }

    public String getShoppingCartModalSuccessOrFailMessage() {
        return getTrimmedElementText(modalShoppingCartSuccessOrFailMessage);
    }

    public int getShoppingCartModalQuantityCount() {
        String quantity = getTrimmedElementText(modalShoppingCartQuantityCount);
        return Integer.parseInt(quantity);
    }
}
