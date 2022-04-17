import heroku.DragDropPage;
import heroku.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class TestDragDropPage extends TestBasePage {

    @Test
    public void testDragDrop() {
        Homepage homepage = new Homepage();
        DragDropPage dragDropPage = homepage.navigateToDragDropPage();
        dragDropPage.dragDrop();

        Assert.assertTrue(dragDropPage.boxAHeader.getText().equals("B"));
    }
}
