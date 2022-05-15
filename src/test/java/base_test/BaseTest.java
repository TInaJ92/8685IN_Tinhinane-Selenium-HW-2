package base_test;

import base.BasePage;
import utils.ExcelData;

import java.io.File;
import java.util.List;

public class BaseTest extends BasePage {

    public static String dataFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
    public static ExcelData excel = new ExcelData(dataFilePath);

}
