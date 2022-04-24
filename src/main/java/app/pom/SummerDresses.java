package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDresses extends SystemBar {

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[1]")
    public WebElement priceSliderLeft;

    @FindBy(xpath = "//div[@id='layered_price_slider']/a[2]")
    public WebElement priceSliderRight;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?id_product=7&controller=product'][@class='quick-view']")
    public WebElement printedChiffonDressQuickViewButton;

    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]")
    public WebElement firstItem;

    public SummerDresses() {
        PageFactory.initElements(driver, this);
    }

    public void moveRightPriceSlider(String percentage) {
        if (Integer.parseInt(percentage) >= 0 && Integer.parseInt(percentage) < 101) {
            priceSliderRight = setElementAttributeValueUsingXpath("//div[@id='layered_price_slider']/a[2]", "style", ("left: " + percentage + "%;"));
        }
    }

    public void hoverOverFirstItem() {
        hoverOverElement(firstItem);
    }

    public void clickPrintedChiffonDressQuickViewButton() {
        safeClickOnElement(printedChiffonDressQuickViewButton);
    }





}
