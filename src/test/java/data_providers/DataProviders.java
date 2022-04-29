package data_providers;

import org.testng.annotations.DataProvider;
import test_base.BaseTest;
import utils.ExcelData;

import java.io.File;
import java.io.IOException;

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
