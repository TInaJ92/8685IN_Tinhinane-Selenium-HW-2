package app.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Catalog extends SystemBar {

    // region Filters elements
    @FindBy(xpath = "//div[@id='layered_price_slider']/a[1]")
    public WebElement priceSliderLeft;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[2]")
    public WebElement priceSliderRight;

    // endregion

    // region Item Catalog elements
    @FindBy(xpath = "//ul[@class='product_list grid row']/p")
    public WebElement loadingIndicator;
    // endregion

    // region Shopping Cart Quick View iFrame elements
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

    // endregion

    // region Shopping Cart Modal elements
    @FindBy(xpath = "//div[@id='layer_cart'][contains(@style, 'display: block;')]")
    public WebElement modalShoppingCart;

    @FindBy(xpath = "//div[contains(@class, 'layer_cart_product')]//h2")
    public WebElement modalShoppingCartSuccessOrFailMessage;

    @FindBy(xpath = "//div[@id='layer_cart']//span[@class='ajax_cart_quantity']")
    public WebElement modalShoppingCartQuantityCount;

    // endregion

    public Catalog() {
        PageFactory.initElements(driver, this);
    }

    public void addItemToCartFromQuickViewFrame(double quantity, String size) {
        switchToShoppingCartQuickViewFrame();
        setProductQuantityQuickViewFrame(quantity);
        selectProductSizeQuickViewFrame(size);
        setColorAtRandomQuickViewFrame();
        clickSubmitButtonQuickViewFrame();
        switchToParentFrame();
    }

    // region Filters methods
    public void setPriceSliderUpperPriceRange(Double upperPriceRange) {
        if (upperPriceRange >= 0 && upperPriceRange <= 100) {

            Actions actions = new Actions(driver);
            actions.clickAndHold(priceSliderRight).build().perform();

            while (Double.parseDouble(driver.findElement(By.id("layered_price_range")).getText().substring(10)) > upperPriceRange) {
                actions.moveByOffset(-3, 0).build().perform();
            }
            actions.release(priceSliderRight).build().perform();
        }
    }

    // endregion

    // region Item Catalog methods
    public void clickItemByIndex(int itemIndex) {
        waitForInvisibilityOfElement(loadingIndicator);
        WebElement item = getClickableElement(By.xpath(
                String.format("//ul[@class='product_list grid row']/li[%s]//a[@class='product_img_link']", itemIndex + 1)));
        safeClickOnElement(item);
    }
    // endregion

    // region Shopping Cart Quick View iFrame methods
    public void switchToShoppingCartQuickViewFrame() {
        switchToFrameByElement(iFrameQuickViewShoppingCart);
    }

    public void setProductQuantityQuickViewFrame(double quantity) {
        clearSendKeysToElement(quantityField, String.valueOf(quantity));
    }

    public void selectProductSizeQuickViewFrame(String size) {
        if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")) {
            selectFromDropdownByVisibleText(sizeComboBox, size.toUpperCase());
        }
    }

    public String getSelectedColor() {
        return selectedColor.getAttribute("title").trim();
    }

    public List<WebElement> getUnselectedColors() {
        return driver.findElements(By.xpath("//ul[@id='color_to_pick_list']/li[not(contains(@class,'selected'))]/a"));
    }

    public void setColorAtRandomQuickViewFrame() {
        List<WebElement> unselectedColors = getUnselectedColors();
        if (unselectedColors.size() == 1) {
            clickOnElement(unselectedColors.get(0));
        } else {
            Random random = new Random();
            int index = random.nextInt(unselectedColors.size() - 1);
            clickOnElement(unselectedColors.get(index));
        }
    }

    public void clickSubmitButtonQuickViewFrame() {
        safeClickOnElement(submitButton);
    }

    public String getShoppingCartModalSuccessOrFailMessage() {
        return getTrimmedElementText(modalShoppingCartSuccessOrFailMessage);
    }

    public int getShoppingCartModalQuantityCount() {
        String quantity = getTrimmedElementText(modalShoppingCartQuantityCount);
        return Integer.parseInt(quantity);
    }

    // endregion
}
