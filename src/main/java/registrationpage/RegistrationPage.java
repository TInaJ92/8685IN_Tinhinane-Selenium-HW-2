package registrationpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import static base.BasePage.driver;

public class RegistrationPage extends BasePage {
        @FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign In')]")
        public WebElement loginLink;
        @FindBy(xpath = "//a[text() = 'Create an Account']")
        public WebElement createAnAccountLink;
        @FindBy(xpath= "//input[@id=\"firstname\"]")
        public WebElement inputFirstName;
        @FindBy(xpath= "//input[@id=\"lastname\"]")
        public WebElement inputLastName;
        @FindBy(xpath= "//input[@type=\"email\"]")
        public WebElement inputEmail;
        @FindBy(xpath= "//input[@type=\"password\"]")
        public WebElement inputPassword;
        @FindBy(xpath= "//input[@name=\"password_confirmation\"]")
        public WebElement inputPasswordConfirmation;
            @FindBy(xpath= "//div[@class=\"primary\"]")
            public WebElement createAnAccountButton;


        public void setInputFirstName(String validFirstName){
            sendKeysToElement(inputFirstName, validFirstName);
        }
        public void setInputLastName(String validLastName){
            sendKeysToElement(inputLastName, validLastName);
        }
        public void setInputEmail(String validEmail){
            sendKeysToElement(inputEmail, validEmail);
        }
        public void setInputPassword(String validPassword){
            sendKeysToElement(inputPassword, validPassword);
        }
        public void setInputPasswordConfirmation(String validPasswordConfirmation){
            sendKeysToElement(inputPasswordConfirmation, validPasswordConfirmation);
        }
        public void clickCreateAnAccountButton(WebElement element) {
            clickOnElement(element);
        }
        public void getRegistrationPage(String validEmail, String validPassword) throws InterruptedException{
            Thread.sleep(5000);
            //clickOnElement(createAnAccountLink);
          //  createAnAccountLink.click();
            driver.findElement(By.xpath("//a[text() = 'Create an Account']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Test123");
            driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys("Test456");
            driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(validEmail);
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(validPassword);
            driver.findElement(By.xpath("//input[@name=\"password_confirmation\"]")).sendKeys(validPassword);
            driver.findElement(By.xpath("//div[@class=\"primary\"]")).click();
            Thread.sleep(5000);
            //setInputFirstName("Test123");
            //setInputLastName("Test456");
            //setInputEmail(validEmail);
            //setInputPassword(validPassword);
            //setInputPasswordConfirmation(validPassword);
            //clickCreateAnAccountButton(createAnAccountButton);


        }

    }
