package test_app.build_acceptance.integration;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;
import utils.Database;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

public class Connectivity extends TestBasePage {

    @Test (groups = {"BAT"}, priority = 1)
    public void testAppServerConnectivity() {
        boolean isConnected = false;

        try {
            InetAddress host = InetAddress.getByName(appConfig.get(Config.AppProperties.HOST));
            if (host.isReachable(5000)) {
                System.out.println("HOST RESPONSE: 200");
                isConnected = true;
            }
        } catch (IOException e) {
            System.out.println("HOST IS NOT REACHABLE");
            e.printStackTrace();
        }
        Assert.assertTrue(isConnected);
    }

    @Test (groups = {"BAT"}, priority = 2)
    public void testDatabaseConnectivity() throws SQLException {
        database = new Database();
        String query = "SELECT 1 FROM DUAL";
        String response = database.executeQueryReadOne(query).toString();
        Assert.assertEquals(response, "1", "DATABASE NOT CONNECTED");
    }
}
