package app.shared;

import app.pom.ContactUs;
import app.pom.Homepage;
import app.pom.Login;
import base.BasePage;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemBar extends BasePage {

    @FindBy(xpath = "//a[@title='Contact Us']")
    public WebElement contactButton;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement accountButton;

    // TODO - Abstract xpath generation based on ENUM values for categories (Women, Dresses, T-shirts)
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women']")
    public WebElement womenCategoryButton;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='Dresses']")
    public WebElement dressesButton;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='T-shirts']")
    public WebElement tShirtsButton;

    @FindBy(xpath = "//ul[@style='display: block;']//a[@title='Summer Dresses']")
    public WebElement summerDressesButtonWomenCategoriesHoverMenu;

    public SystemBar() {
        PageFactory.initElements(driver, this);
    }

    public Login clickLoginButton() {
        safeClickOnElement(loginButton);

        return new Login();
    }

    public Homepage clickLogoutButton() {
        try {
            isElementVisible(logoutButton);
        } catch (ElementNotVisibleException | TimeoutException e) {
            System.out.println("Logout button was not made visible");
        }

        safeClickOnElement(logoutButton);

        return new Homepage();
    }

    public ContactUs clickContactButton() {
        safeClickOnElement(contactButton);

        return new ContactUs();
    }

    public Catalog clickWomenCategoriesButton() {
        try {
            isElementVisible(womenCategoryButton);
        } catch (ElementNotVisibleException | TimeoutException e) {
            System.out.println("Women Category button was not made visible");
        }

        safeClickOnElement(womenCategoryButton);

        return new Catalog();
    }

    public Catalog clickDressesButton() {
        try {
            isElementVisible(dressesButton);
        } catch (ElementNotVisibleException | TimeoutException e) {
            System.out.println("Dresses button was not made visible");
        }

        safeClickOnElement(dressesButton);

        return new Catalog();
    }

    public Catalog clickTShirtsButton() {
        try {
            isElementVisible(tShirtsButton);
        } catch (ElementNotVisibleException | TimeoutException e) {
            System.out.println("Dresses button was not made visible");
        }

        safeClickOnElement(tShirtsButton);

        return new Catalog();
    }

    public void hoverWomenCategoriesButton() {
        try {
            isElementVisible(womenCategoryButton);
        } catch (ElementNotVisibleException | TimeoutException e) {
            System.out.println("Women Category button was not made visible");
        }

        hoverOverElement(womenCategoryButton);
    }

    public Catalog clickSummerDressesButtonWomenCategoriesHoverMenu() {
        safeClickOnElement(summerDressesButtonWomenCategoriesHoverMenu);

        return new Catalog();
    }

    public boolean isSignedIn() {
        boolean isSignedIn = false;

        if (isElementVisible(accountButton)) {
            isSignedIn = true;
        }

        return isSignedIn;
    }

}
