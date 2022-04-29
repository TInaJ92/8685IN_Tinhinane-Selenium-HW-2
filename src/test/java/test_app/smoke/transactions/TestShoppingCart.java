package test_app.smoke.transactions;

import annotations.RetryCount;
import app.pom.Homepage;
import app.shared.Catalog;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.BaseTest;

public class TestShoppingCart extends BaseTest {

    @RetryCount(1)
    @Test (groups = {"smoke"})
    public void testAddItemToCart() {
        Homepage homepage = new Homepage();
        homepage.hoverWomenCategoriesButton();
        Catalog summerDresses = homepage.clickSummerDressesButtonWomenCategoriesHoverMenu();

        summerDresses.setPriceSliderUpperPriceRange(20.00);
        summerDresses.clickItemByIndex(0);

        int desiredQuantity = 3;
        String size = "M";
        summerDresses.addItemToCart(desiredQuantity, size);

        String expectedMessage = excel.readStringArray("testAddItemToCart")[0];

        Assert.assertEquals(summerDresses.getShoppingCartModalSuccessOrFailMessage(), expectedMessage);
        Assert.assertEquals(summerDresses.getShoppingCartModalQuantityCount(), desiredQuantity);

    }
}
