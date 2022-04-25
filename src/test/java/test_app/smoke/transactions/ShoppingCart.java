package test_app.smoke.transactions;

import app.pom.Homepage;
import app.pom.SummerDresses;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;

public class ShoppingCart extends TestBasePage {

    @Test
    public void testAddItemToCart() {
        Homepage homepage = new Homepage();
        homepage.hoverOverWomenButton();
        SummerDresses summerDresses = homepage.clickWomenHoverMenuDressesSummerDressesButton();

        summerDresses.setUpperPriceRange(20.00);
        summerDresses.hoverOverFirstItem();
        summerDresses.clickPrintedChiffonDressQuickViewButton();

        int desiredQuantity = 3;
        String size = "M";
        summerDresses.addItemToCart(desiredQuantity, size);

        String expectedMessage = "Product successfully added to your shopping cart";

        Assert.assertEquals(summerDresses.getShoppingCartModalSuccessOrFailMessage(), expectedMessage);
        Assert.assertEquals(summerDresses.getShoppingCartModalQuantityCount(), desiredQuantity);

    }
}
