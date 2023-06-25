package app.pom.contactPage;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.Name;



    public class ContactPage extends BasePage {
        public ContactPage(){
            PageFactory.initElements(driver,this);
        }
        @FindBy(xpath = "//a[normalize-space()=\"Contact Us\"]")
        public WebElement contactUsButton;
        @FindBy(xpath = "//input[@id=\"name\"]")
        public WebElement inputName;
        @FindBy(xpath = "//input[@id=\"email\"]")
        public WebElement inputEmail;
        @FindBy(xpath = "//input[@id=\"telephone\"]")
        public WebElement inputPhoneNumber;
        @FindBy(xpath = "//textarea[@id=\"comment\"]")
        public WebElement inputCommit;
        @FindBy(xpath = "//button[@title=\"Submit\"]")
        public WebElement SubmitButton;
        @FindBy(xpath = "//div[@class=\"page messages\"]")
        public WebElement Message;
        public void doContactUs(String name, String email, String phoneNumber, String commit){
            safeClickOnElement(contactUsButton);
            sendKeysToElement(inputName,name);
            sendKeysToElement(inputEmail,email);
            sendKeysToElement(inputPhoneNumber, phoneNumber);
            sendKeysToElement(inputCommit, commit);
            safeClickOnElement(SubmitButton);
            safeClickOnElement(Message);


        }
    }

