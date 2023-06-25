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

    @FindBy (xpath ="//button[@title='Add to Cart']")
    public WebElement addToCartBtn;

    @FindBy (xpath ="//div[@attribute-code='size']/div/div[2]")
    public WebElement sizeBtn;

    @FindBy (xpath ="(//div[@class='swatch-option color'])[1]")
    public WebElement colorBtn;

    @FindBy (xpath ="//a[@class='action showcart']")
    public WebElement addToCartIcon;


    @FindBy (xpath ="//button[@title='Subscribe']")
    public WebElement subscriptionBtn;

    @FindBy (xpath ="//div[contains(text(), 'This email address is already subscribed.')]")
    public WebElement errorMessage;

    @FindBy (xpath ="//input[@name=\"email\"]")
    public WebElement emailToSubscribe;
    @FindBy (xpath ="//span\"([@class=\"product-image-container\"])[1]")
    public WebElement itemIcon;;

    @FindBy (xpath ="//a[@class='action showcart']")
    public WebElement addToCartlink;





}

