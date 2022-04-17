package php;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//div[@id='PageContainer']//section[@class='grey-box']//div[@class='container']/div/div[2]//a[@href='//www.phptravels.net/login'][@class='btn btn-primary btn-lg btn-block']")
    public WebElement customerFrontEndButton;

    @FindBy(xpath = "//div[@id='PageContainer']//section[@class='grey-box']//div[@class='container']/div/div[3]//a[@href='//www.phptravels.net/login'][@class='btn btn-primary btn-lg btn-block']")
    public WebElement agentFrontEndButton;

    @FindBy(xpath = "//div[@id='PageContainer']//section[@class='grey-box']//div[@class='container']/div/div[4]//a[@href='//www.phptravels.net/admin'][@class='btn btn-primary btn-lg btn-block']")
    public WebElement adminBackEndButton;

    @FindBy(xpath = "//div[@id='PageContainer']//section[@class='grey-box']//div[@class='container']/div/div[5]//a[@href='//www.phptravels.net/supplier'][@class='btn btn-primary btn-lg btn-block']")
    public WebElement supplierBackEndButton;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public CustomerLoginPage navigateToCustomerLoginPage() {
        clickOnElement(customerFrontEndButton);
        switchTabs();
        return new CustomerLoginPage();
    }

    public AgentLoginPage navigateToAgentLoginPage() {
        clickOnElement(agentFrontEndButton);

        return new AgentLoginPage();
    }

    public AdminLoginPage navigateToAdminLoginPage() {
        clickOnElement(adminBackEndButton);

        return new AdminLoginPage();
    }

    public SupplierLoginPage navigateToSupplierLoginPage() {
        clickOnElement(supplierBackEndButton);

        return new SupplierLoginPage();
    }
}
