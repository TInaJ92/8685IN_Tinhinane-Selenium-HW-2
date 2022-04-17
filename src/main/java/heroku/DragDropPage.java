package heroku;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DragDropPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/drag_and_drop";

    @FindBy(id = "column-a")
    public WebElement boxA;

    @FindBy(xpath = "//div[@id='column-a']/header")
    public WebElement boxAHeader;

    @FindBy(id = "column-b")
    public WebElement boxB;

    @FindBy(xpath = "//div[@id='column-b']/header")
    public WebElement boxBHeader;

    public DragDropPage() {
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
        PageFactory.initElements(driver, this);
    }

    public void dragDrop() {
        Actions builder = new Actions(driver);
        Action dragDrop = builder.dragAndDrop(boxA, boxB).build();

        dragDrop.perform();
    }
}
