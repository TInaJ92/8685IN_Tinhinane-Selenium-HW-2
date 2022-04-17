import heroku.Homepage;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class TestCheckBoxPage extends TestBasePage {

    @Test
    public void testCheckBox() {
        Homepage homepage = new Homepage();
        homepage.navigateToCheckBoxPage().iterateThroughCheckboxes();
    }
}
