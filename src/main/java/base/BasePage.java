package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.*;

public class BasePage {

    public static Map<Object, String> appConfig = Config.appConfig();
    public static Map<Object, String> databaseConfig = Config.databaseConfig();
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static WebDriverWait syncWait;
    public static ExtentReports extent;
    public static JavascriptExecutor jsDriver = (JavascriptExecutor) (driver);

    // region Hooks
    @BeforeSuite(alwaysRun = true)
    public void reportSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void reportInit(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        ExtentTestManager.startTest(methodName);
        ExtentTestManager.getTest().assignCategory(className);
    }

    @Parameters({"enabled", "browser"})
    @BeforeMethod
    public void driverSetup(@Optional("true") String enabled, @Optional("chrome") String browser) {
        if (enabled.equalsIgnoreCase("true")) {
            driverInit(browser);
            driver.get(appConfig.get(Config.AppProperties.URL));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    @Parameters({"enabled"})
    @AfterMethod
    public void cleanUp(@Optional("true") String enabled) {
        if (enabled.equalsIgnoreCase("true")) {
            driver.close();
            driver.quit();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {

        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName());
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            captureScreenshot(driver, result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());
        }

        ExtentTestManager.endTest();
        extent.flush();
    }

    // endregion

    // region Selenium API
    public String getElementText(WebElement element) {
        String text = "";
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        text = element.getText();

        if (text.equals("")) {
            text = element.getAttribute("innerHTML");
        }

        return text;
    }

    public void clickOnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void jsClickOnElement(WebElement element) {
        jsDriver.executeScript("arguments[0].click();", element);
    }

    public void safeClickOnElement(WebElement element) {
        try {
            clickOnElement(element);
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            System.out.println("Unable to click - trying again");
            jsClickOnElement(element);
        } catch (TimeoutException | ElementNotVisibleException e) {
            System.out.println("Unable to locate element - check element locator");
        }
    }

    public void sendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void selectFromDropdownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropdownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectFromDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            syncWait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void switchToTab() {
        String parentHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
            }
        }
    }

    // endregion

    // region Helper Methods
    private static void driverInit(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        syncWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    private static void captureScreenshot(WebDriver driver, String testName) {
        String absPath = System.getProperty("user.dir");
        String screenshotFileName = "screenshot_" + testName + ".png";
        String fullScreenshotFileName = "full_screenshot_" + testName + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + screenshotFileName);
        File fullScreenshot = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        File fullScreenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + fullScreenshotFileName);

        try {
            FileHandler.copy(screenshot, screenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }

        try {
            FileHandler.copy(fullScreenshot, fullScreenshotFile);
            System.out.println("FULL SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING FULL SCREENSHOT: " + e.getMessage());
        }
    }

    private static Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    // endregion

}
