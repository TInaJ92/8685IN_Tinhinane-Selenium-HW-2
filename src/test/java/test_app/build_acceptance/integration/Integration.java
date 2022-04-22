package test_app.build_acceptance.integration;

import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBasePage;
import utils.Database;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class Integration extends TestBasePage {

    @Test (groups = {"BAT"})
    public void testAppServerConnectivity() throws UnknownHostException {
        InetAddress host = InetAddress.getByName(appConfig.get(Config.AppProperties.HOST));
        boolean isConnected = false;

        try {
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

    @Test (groups = {"BAT"})
    public void testDatabaseConnectivity() throws SQLException {
        database = new Database();
        String query = "SELECT 1 FROM DUAL";
        String response = database.executeQueryReadOne(query).toString();
        Assert.assertEquals(response, "1", "DATABASE NOT CONNECTED");
    }
}
