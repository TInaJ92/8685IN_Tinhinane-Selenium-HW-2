package data_providers;

import org.testng.annotations.DataProvider;
import utils.ExcelData;

import java.io.File;
import java.io.IOException;

public class DataProviders {

    ExcelData excel = new ExcelData();
    String absPath = System.getProperty("user.dir");
    String relPath = File.separator + "src" + File.separator + "test" + File.separator + "resources"
            + File.separator + "test_data.xlsx";
    String path = absPath + relPath;

    @DataProvider (name = "DP1")
    public Object[][] getValidEmailInvalidPasswordLoginData() throws IOException {
        String sheetName = "LoginValidEmailInvalidPass";

        return excel.readStringArrays(path, sheetName);
    }

    @DataProvider (name = "DP2")
    public Object[][] getInvalidEmailValidPasswordLoginData() throws IOException {
        String sheetName = "LoginInvalidEmailValidPass";

        return excel.readStringArrays(path, sheetName);
    }

}
