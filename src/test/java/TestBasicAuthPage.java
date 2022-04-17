import heroku.BasicAuthPage;
import heroku.Homepage;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class TestBasicAuthPage extends TestBasePage {

    @Test
    public void testBasicAuthLogin() {
        Homepage homepage = new Homepage();
        BasicAuthPage basicAuthPage = homepage.navigateToBasicAuthPage();
        basicAuthPage.login();
    }
}
