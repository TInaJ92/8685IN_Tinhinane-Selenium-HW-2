import org.testng.Assert;
import org.testng.annotations.Test;
import php.CustomerHomepage;
import php.IndexPage;
import test_base.TestBasePage;

public class TestCustomerLoginPage extends TestBasePage {

    @Test
    public void testValidLogin() {
        IndexPage indexPage = new IndexPage();
        String email = properties.getProperty("customer_id");
        String password = properties.getProperty("customer_password");

        CustomerHomepage customerHomepage = indexPage.navigateToCustomerLoginPage().login(email, password);

        Assert.assertTrue(isElementVisible(customerHomepage.dashboardButton));
    }
}
