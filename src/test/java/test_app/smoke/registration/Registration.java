package test_app.smoke.registration;

import app.pom.CreateAccount;
import app.pom.Homepage;
import app.pom.Login;
import app.pom.MyAccount;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;
import utils.GenerateData;

public class Registration extends TestBasePage {

    @Test
    public void testProcessNewUserRegistration() {
        Homepage homepage = new Homepage();
        Login login = homepage.clickLoginButton();

        String emailAddress = GenerateData.email();
        CreateAccount createAccount = login.createAccount(emailAddress);

        String firstName = GenerateData.firstName();
        String lastName = GenerateData.lastName();
        String password = GenerateData.password();
        String[] dob = GenerateData.dateOfBirth();
        String day = dob[0];
        String monthNumber = dob[1];
        String year = dob[2];
        String streetAddress = GenerateData.streetAddress();
        String city = GenerateData.city();
        String state = GenerateData.state();
        String zipCode = GenerateData.zipCode();
        String phoneNumber = GenerateData.mobilePhone();

        MyAccount myAccount = createAccount.registerNewUser(firstName, lastName, password, day, monthNumber, year,
                streetAddress, city, state, zipCode, phoneNumber);

        String name = getElementText(myAccount.accountButton);
        String[] splitName = name.split(" ");
        String actualFirstName = splitName[0];
        String actualLastName = splitName[1];

        Assert.assertTrue(isElementVisible(myAccount.accountButton));
        Assert.assertTrue(firstName.equalsIgnoreCase(actualFirstName));
        Assert.assertTrue(lastName.equalsIgnoreCase(actualLastName));
    }
}
