package test_app;

import app.pom.homepage.Homepage;
import base.BasePage;
import contactPage.ContactPage;
import loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import registrationpage.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestApp extends BasePage {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test(priority = 0, groups = {"BAT"}, enabled = false)
    public void testNavigationToApplication() {
        Homepage homepage = new Homepage();
        Assert.assertTrue(isElementVisible(homepage.logo));

    }
    @Test(priority = 1, groups = {"BAT"}, enabled = false)
    public void testLogin(){

        LoginPage logInPage= new LoginPage();
        String validEmail ="tinatebany@gmail.com";
        String validPassword="Qwerty2023/*-";
        logInPage.getLogIn(validEmail,validPassword);

    }

    @Test(priority = 2, groups = {"BAT"}, enabled = false)
    public void accountRegistration() throws InterruptedException{
        testNavigationToApplication();

        registrationPage.getRegistrationPage("test67@gmail.com", "Test768456#");

    }
    @Test (priority = 3, groups = {"BAT"}, enabled = false)
    public void userIsAbleToSearchForAnItem() throws InterruptedException {

       testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Yoga");
        clickOnElement(homepage.searchBtn);
        Assert.assertTrue(isElementVisible(homepage.searchItem));

}


    @Test(priority = 4,groups = {"BAT"})
    public void ContactPage(){
        ContactPage page=new ContactPage();
        String name="juba";
        String email="jubatt@gmail.com";
        String phoneNumber="2145698787";
        String commit= "Hello Word";
        page.doContactUs(name,email,phoneNumber,commit);
        Assert.assertTrue(isElementVisible(page.Message));
    }




     /*@Test(enabled = false)
    public void userIsAbleToAddAnItemToTheCart() throws InterruptedException {
        testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Dash Digital Watch");
        clickOnElement(homepage.searchBtn);
        Thread.sleep(6000);
        clickOnElement(homepage.itemIcon);
        Thread.sleep(4000);
        // clickOnElement(homepage.sizeBtn);
        // clickOnElement(homepage.colorBtn);
        clickOnElement(homepage.addToCartBtn);
        Thread.sleep(4000);
        clickOnElement(homepage.addToCartIcon);
        Thread.sleep(2000);
    }*/


















     /*@Test(enabled = false)
    public void userIsAbleToSubscribe() throws InterruptedException {

        Homepage homepage = new Homepage();
        Thread.sleep(4000);
        sendKeysToElement(homepage.emailToSubscribe, "test2@gmail.com");
        clickOnElement(homepage.subscriptionBtn);
        System.out.println("clicked on subscribe button");
        Thread.sleep(2000);
        Assert.assertTrue(isElementVisible(homepage.errorMessage));
    }*/
}
















































  /*@Test (enabled = false)
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
  /*@Test(enabled = true)
  public void userIsAbleToSelectElement() throws InterruptedException {
      testNavigationToApplication();
      Homepage homepage = new Homepage();
      sendKeysToElement(homepage.searchBar, " t-shirt");
      clickOnElement(homepage.searchBtn);
      Assert.assertTrue(isElementVisible(homepage.searchItem));
      clickOnElement(homepage.searchItem);*/

      //WebElement element = driver.findElement(By.xpath("//span[@class=\"product-image-container\"]"));

      // Use Select class to interact with dropdowns
    //Select selectElement = new Select(elementToSelect);

      // Select an option by visible text
    //selectByVisibleText("Option 1");

      // Verify that the selected option matches the expected value
     // WebElement selectedOption = selectElement.getFirstSelectedOption();
     // String selectedText = selectedOption.getText();
        //Assert.assertEquals("Option 1", selectedText);

      // Close the browser


       //safeClickOnElement();
     //Click on the product to view its details.
      //Select the desired quantity and click on the "Add to Cart" button.
        //  Verify that the product is added to the cart.
      //Validate that the cart displays the correct product and quantity.
      //Assert.assertTrue(isElementVisible(homepage.));




