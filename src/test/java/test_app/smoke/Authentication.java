package test_app.smoke;

import app.Homepage;
import app.LoginPage;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_base.TestBasePage;

public class Authentication extends TestBasePage {

    @Test
    public void testLoginValidUserValidPassword() {
        Homepage homepage = new Homepage();
        String username = appConfig.get(Config.AppProperties.USER);
        String password = appConfig.get(Config.AppProperties.PASSWORD);

        homepage.clickSignInButton().login(username, password);
    }

    @Test
    public void testLoginValidUserInvalidPassword() {
        Homepage homepage = new Homepage();
        String username = appConfig.get(Config.AppProperties.USER);
        String password = appConfig.get(Config.AppProperties.PASSWORD) + "1";

        LoginPage login = homepage.clickSignInButton();
        login.login(username, password);

        String errorMessage = "Authentication failed.";
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertTrue(isElementVisible(login.errorMessageBanner), "Error Banner was never made available");
        sAssert.assertEquals(getElementText(login.errorMessageText), errorMessage, "Error Message does not match");
        sAssert.assertAll();
    }
}
