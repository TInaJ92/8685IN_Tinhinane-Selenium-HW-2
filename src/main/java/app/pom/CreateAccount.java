package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends SystemBar {

    @FindBy(id = "customer_firstname")
    public WebElement firstNameInputField;

    @FindBy(id = "customer_lastname")
    public WebElement lastNameInputField;

    @FindBy(id = "passwd")
    public WebElement passwordInputField;

    @FindBy(id = "days")
    public WebElement dobDayComboBox;

    @FindBy(id = "months")
    public WebElement dobMonthComboBox;

    @FindBy(id = "years")
    public WebElement dobYearComboBox;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    public WebElement specialOffersCheckBox;

    @FindBy(id = "address1")
    public WebElement streetAddressInputField;

    @FindBy(id = "city")
    public WebElement cityInputField;

    @FindBy(id = "id_state")
    public WebElement stateComboBox;

    @FindBy(id = "postcode")
    public WebElement zipCodeField;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhoneInputField;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

    public CreateAccount() {
        PageFactory.initElements(driver, this);
    }

    public MyAccount registerNewUser(String firstName, String lastName, String password, String day, String monthNumber,
                                String year, String streetAddress, String city, String state, String zipCode,
                                String phoneNumber) {
        inputFirstName(firstName);
        inputLastName(lastName);
        inputPassword(password);
        selectDobDay(day);
        selectDobMonth(monthNumber);
        selectDobYear(year);
        clickNewsletterCheckBox();
        clickSpecialOffersCheckBox();
        inputStreetAddress(streetAddress);
        inputCity(city);
        selectState(state);
        inputZipCode(zipCode);
        inputMobilePhoneNumber(phoneNumber);
        clickRegisterButton();

        return new MyAccount();
    }

    public void inputFirstName(String firstName) {
        sendKeysToElement(firstNameInputField, firstName);
    }

    public void inputLastName(String lastName) {
        sendKeysToElement(lastNameInputField, lastName);
    }

    public void inputPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    public void selectDobDay(String day) {
        if (Integer.parseInt(day) > 0 && Integer.parseInt(day) <= 31) {
            selectFromDropdownByValue(dobDayComboBox, day);
        }
    }

    public void selectDobMonth(String monthNumber) {
        if (Integer.parseInt(monthNumber) > 0 && Integer.parseInt(monthNumber) <= 12) {
            selectFromDropdownByValue(dobMonthComboBox, monthNumber);
        }
    }

    public void selectDobYear(String year) {
        if (Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 2022) {
            selectFromDropdownByValue(dobYearComboBox, year);
        }
    }

    public void clickNewsletterCheckBox() {
        jsClickOnElement(newsletterCheckBox);
    }

    public void clickSpecialOffersCheckBox() {
        jsClickOnElement(specialOffersCheckBox);
    }

    public void inputStreetAddress(String streetAddress) {
        sendKeysToElement(streetAddressInputField, streetAddress);
    }

    public void inputCity(String city) {
        sendKeysToElement(cityInputField, city);
    }

    public void selectState(String state) {
        selectFromDropdownByVisibleText(stateComboBox, state);
    }

    public void inputZipCode(String zipCode) {
        sendKeysToElement(zipCodeField, zipCode);
    }

    public void inputMobilePhoneNumber(String phoneNumber) {
        sendKeysToElement(mobilePhoneInputField, phoneNumber);
    }

    public void clickRegisterButton() {
        safeClickOnElement(registerButton);
    }
}
