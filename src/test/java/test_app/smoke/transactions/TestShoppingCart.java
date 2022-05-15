package test_app.smoke.transactions;

import annotations.RetryCount;
import app.pom.Homepage;
import app.shared.Catalog;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.BaseTest;

import java.util.HashMap;

public class TestShoppingCart extends BaseTest {

    @RetryCount(1)
    @Test (groups = {"smoke", "transactions"})
    public void testAddItemToCart() {
        Homepage homepage = new Homepage();
        homepage.hoverWomenCategoriesButton();
        Catalog summerDresses = homepage.clickSummerDressesButtonWomenCategoriesHoverMenu();

        summerDresses.setPriceSliderUpperPriceRange(20.00);
        summerDresses.clickItemByIndex(0);

        HashMap<String, String> dataModel = excel.getDataModel("testAddItemToCartModel");

        double desiredQuantity = Double.parseDouble(dataModel.get("quantity"));
        String size = dataModel.get("size");
        summerDresses.addItemToCartFromQuickViewFrame(desiredQuantity, size);

        String expectedMessage = excel.readStringArray("testAddItemToCart")[0];

        Assert.assertEquals(summerDresses.getShoppingCartModalSuccessOrFailMessage(), expectedMessage);
        Assert.assertEquals(summerDresses.getShoppingCartModalQuantityCount(), desiredQuantity);

    }
}
