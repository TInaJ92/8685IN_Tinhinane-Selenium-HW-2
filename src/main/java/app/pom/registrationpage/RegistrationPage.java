package app.pom.registrationpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import static base.BasePage.driver;

public class RegistrationPage extends BasePage {


        public void getRegistrationPage(String validEmail, String validPassword) throws InterruptedException{
            Thread.sleep(5000);

            driver.findElement(By.xpath("//a[text() = 'Create an Account']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Test123");
            driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys("Test456");
            driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(validEmail);
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(validPassword);
            driver.findElement(By.xpath("//input[@name=\"password_confirmation\"]")).sendKeys(validPassword);
            driver.findElement(By.xpath("//div[@class=\"primary\"]")).click();
            Thread.sleep(5000);



        }

    }
