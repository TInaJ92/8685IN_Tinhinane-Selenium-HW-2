import heroku.DropdownPage;
import heroku.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class TestDropdownPage extends TestBasePage {

    @Test
    public void testSelectFromDropdown() {
        Homepage homepage = new Homepage();
        DropdownPage dropdownPage = homepage.navigateToDropdownPage();
        dropdownPage.selectDropdownOption("Option 2");

        Assert.assertTrue(dropdownPage.dropdownOptionTwo.isSelected());
    }
}
