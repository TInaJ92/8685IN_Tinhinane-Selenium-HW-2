package test_base;

import base.BasePage;
import utils.ExcelData;

import java.io.File;

public class BaseTest extends BasePage {

    public static String dataFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
    public static ExcelData excel = new ExcelData(dataFilePath);

}
