package test_app;

import app.pom.homepage.Homepage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApp extends BasePage {

    @Test (priority = 0, groups = {"BAT"})
    public void testNavigationToApplication() {
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }

}
