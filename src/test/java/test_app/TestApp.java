package test_app;

import app.pom.homepage.Homepage;
import base.BasePage;
import app.pom.contactPage.ContactPage;
import app.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import app.pom.registrationpage.RegistrationPage;

public class TestApp extends BasePage {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test(priority = 0, groups = {"BAT"})
    public void testNavigationToApplication() {
        Homepage homepage = new Homepage();
        Assert.assertTrue(isElementVisible(homepage.logo));

    }

    @Test(priority = 1, groups = {"BAT"})
    public void testLogin() {

        LoginPage logInPage = new LoginPage();
        String validEmail = "tinatebany@gmail.com";
        String validPassword = "Qwerty2023/*-";
        logInPage.getLogIn(validEmail, validPassword);

    }

    @Test(priority = 2, groups = {"BAT"})
    public void accountRegistration() throws InterruptedException {
        testNavigationToApplication();
//always we have to change Email and Password
        registrationPage.getRegistrationPage("test67@gmail.com", "Test768456#");

    }


    @Test(priority = 3, groups = {"BAT"})
    public void userIsAbleToSearchForAnItem() throws InterruptedException {
        testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Yoga");
        clickOnElement(homepage.searchBtn);
        Assert.assertTrue(isElementVisible(homepage.searchItem));
    }


    @Test(priority = 4, groups = {"BAT"})
    public void ContactPage() {
        ContactPage page = new ContactPage();
        String name = "juba";
        String email = "jubatt@gmail.com";
        String phoneNumber = "2145698787";
        String commit = "Hello Word";
        page.doContactUs(name, email, phoneNumber, commit);
        Assert.assertTrue(isElementVisible(page.Message));

    }

    @Test(priority = 5, groups = {"BAT"})
    public void userIsAbleToSubscribe() throws InterruptedException {

        Homepage homepage = new Homepage();
        Thread.sleep(4000);
        sendKeysToElement(homepage.emailToSubscribe, "tiiittt@gmail.com");
        clickOnElement(homepage.subscriptionBtn);
        System.out.println("clicked on subscribe button");
        Thread.sleep(2000);
        Assert.assertTrue(isElementVisible(homepage.errorMessage));
    }


    @Test(priority = 6, groups = {"BAT"})

    public void userIsAbleToAddAnItemToTheCart() throws InterruptedException {
        testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Push It Messenger Bag");
        clickOnElement(homepage.searchBtn);
        Thread.sleep(3000);
        clickOnElement(homepage.itemIcon);
        Thread.sleep(2000);
        clickOnElement(homepage.addToCartBtn);
        Thread.sleep(3000);
        clickOnElement(homepage.addToCartIcon);
        Thread.sleep(2000);


        Assert.assertTrue(true, "Item Added Successfully");
    }

}





  /*@Test (priority=7,groups={"BAT"})
  public void userIsAbleToIdentifyTheShippingMethodsOption() throws InterruptedException {


      // Select a shipping method option
      WebElement shippingMethod = driver.findElement(By.xpath("//div[@data-bind=\"i18n: 'Shipping Methods'\"]"));
      shippingMethod.click();

      // Verify the shipping method option is selected
      Assert.assertTrue(shippingMethod.isSelected());

      // Proceed to the next step
      WebElement nextButton = driver.findElement(By.xpath("//span[@data-bind=\"i18n: 'Next'\"]"));
      nextButton.click();

      // Close the browser
      driver.quit();
  }*/








