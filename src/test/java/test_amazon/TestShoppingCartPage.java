package test_amazon;

import amazon.Homepage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShoppingCartPage extends BasePage {

    @Test
    public void testAddItemToCart() {
        Homepage homepage = new Homepage();
        String searchTerm = "watches";

        Assert.assertTrue(homepage.doSearch(searchTerm)
                .clickFirstSearchResult()
                .selectQuantityAddItemToCart("1")
                .confirmationMessage.isDisplayed());
    }
}
