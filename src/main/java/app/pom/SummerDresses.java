package app.pom;

import app.shared.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDresses extends Products {

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

    public void setUpperPriceRange(Double upperPriceRange) {
        if (upperPriceRange >= 0 && upperPriceRange <= 100) {

            Actions actions = new Actions(driver);

            while (Double.parseDouble(driver.findElement(By.id("layered_price_range")).getText().substring(10)) > upperPriceRange) {
                actions.clickAndHold(priceSliderRight).build().perform();
                actions.moveByOffset(-5, 0).build().perform();
                actions.release(priceSliderRight).build().perform();
            }
        }
    }

    public void hoverOverFirstItem() {
        hoverOverElement(firstItem);
    }

    public void clickPrintedChiffonDressQuickViewButton() {
        safeClickOnElement(printedChiffonDressQuickViewButton);
    }

}
