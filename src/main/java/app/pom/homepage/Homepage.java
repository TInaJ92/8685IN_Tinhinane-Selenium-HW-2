package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy (xpath = "//a[@href='https://magento.softwaretestingboard.com/']")
    public WebElement logo;

    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@id='search']")
    public WebElement searchBar;
    //  WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));

    @FindBy (xpath = "//button[@title='Search']")
    public WebElement searchBtn;

    @FindBy (xpath = "//a[contains(text(), 'Josie Yoga Jacket' )]")
    public WebElement searchItem;


   /* @FindBy (xpath ="//span[@class=\"product-image-container\"]")
    public WebElement getSearchItem;
    @FindBy (xpath = "//dd[@class=\"item\"]")
    public WebElement getGetSearchItem;*/

   /* @FindBy (xpath = "//div[@data-bind="i18n: 'Shipping Methods'"]")
    public WebElement shippingMethod;
    @FindBy (xpath = "\"//span[@data-bind="i18n: 'Next'"]"")
    public WebElement clickBtn*/

}

