package data_providers;

import org.testng.annotations.DataProvider;
import base_test.BaseTest;

public class DataProviders extends BaseTest {

    @DataProvider (name = "DP1")
    public static Object[][] getValidEmailInvalidPasswordLoginData() {
        String sheetName = "LoginValidEmailInvalidPass";

        return excel.readStringArrays(sheetName);
    }

    @DataProvider (name = "DP2")
    public static Object[][] getInvalidEmailValidPasswordLoginData() {
        String sheetName = "LoginInvalidEmailValidPass";

        return excel.readStringArrays(sheetName);
    }

}
