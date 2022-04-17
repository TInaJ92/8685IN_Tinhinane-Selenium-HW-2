package heroku;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/checkboxes";

    @FindBy(id = "checkboxes")
    public WebElement checkBoxForm;

    @FindBy(xpath = "//form[@id='checkboxes']/input")
    public List<WebElement> checkBoxOptions;

    public CheckBoxPage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        PageFactory.initElements(driver, this);
    }

    public void iterateThroughCheckboxes() {
        for (int i = 0; i < 10; i++) {
            for (WebElement e : checkBoxOptions) {
                e.click();
            }
        }
    }


}
