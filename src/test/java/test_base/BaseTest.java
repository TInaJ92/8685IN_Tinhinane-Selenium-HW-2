package test_base;

import base.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Database;
import utils.ExcelData;

import java.io.File;
import java.sql.SQLException;

public class BaseTest extends BasePage {

    public static Database db;
    public static String dataFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
    public static ExcelData excel = new ExcelData(dataFilePath);

    @BeforeMethod(alwaysRun = true)
    public void dbInit() {
        db = new Database();
    }

    @AfterMethod(alwaysRun = true)
    public void dbCleanUp() {
        if (db.connect != null) {
            try {
                db.connect.close();
                System.out.println("SUCCESSFULLY CLOSED DATABASE CONNECTION");
            } catch (SQLException e) {

                e.printStackTrace();
            }
        } else {
            System.out.println("NON-EXISTENT DATABASE CONNECTION");
        }
    }



}
