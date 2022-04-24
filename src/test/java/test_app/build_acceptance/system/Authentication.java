package test_app.build_acceptance.system;

import app.pom.Homepage;
import app.pom.MyAccount;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class Authentication extends TestBasePage {

    @Test (groups = {"BAT"})
    public void testValidLogin() {
        Homepage homepage = new Homepage();
        String username = appConfig.get(Config.AppProperties.USER);
        String password = appConfig.get(Config.AppProperties.PASSWORD);

        MyAccount myAccount = homepage.clickLoginButton().login(username, password);

        Assert.assertTrue(isElementVisible(myAccount.accountButton));
    }

//    @Test (groups = {"BAT"}, dataProviderClass = data_providers.DataProviders.class, dataProvider = "DP1")
//    public void testInvalidLogin(String username, String password) {
//        Homepage homepage = new Homepage();
//        Login login = homepage.clickLoginButton();
//        login.login(username, password);
//        String expectedText;
//
//        if (isElementVisible(login.invalidEmailInputField)) {
//            expectedText = "Invalid email address.";
//        } else {
//            expectedText = "Authentication failed.";
//        }
//
//        Assert.assertTrue(isElementVisible(login.errorMessageBanner) && (getElementText(login.errorMessageText).equals(expectedText)));
//    }
}
