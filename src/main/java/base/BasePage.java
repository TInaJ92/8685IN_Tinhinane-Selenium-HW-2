package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.DriverEventListener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.*;
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
import java.util.NoSuchElementException;

public class BasePage {

    public static Map<Object, String> appConfig;
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Wait<WebDriver> fluentWait;
    public static ExtentReports extent;
    public static JavascriptExecutor jsDriver;

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

    @BeforeMethod(alwaysRun = true)
    public void initConfig() {
        appConfig = Config.appConfig();
    }

    @Parameters({"browser", "canRunDriver"})
    @BeforeMethod
    public void driverSetup(@Optional("chrome") String browser, @Optional("true") String canRunDriver) {
        if (Boolean.parseBoolean(canRunDriver)) {
            long explicit_timeout = Long.parseLong(appConfig.get("explicit_timeout_seconds"));
            long fluent_timeout = Long.parseLong(appConfig.get("fluent_timeout_seconds"));
            long polling_interval = Long.parseLong(appConfig.get("polling_interval_ms"));

            driverInit(browser, explicit_timeout, fluent_timeout, polling_interval);
            driver.get(appConfig.get(Config.AppProperties.URL));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    @AfterMethod ()
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

    @Parameters()
    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult testResult, @Optional("true") String driverConfigEnabled) {
        ExtentTest test = ExtentTestManager.getTest();
        String testName = testResult.getName();
        int testStatus = testResult.getStatus();

        test.getTest().setStartedTime(getTime(testResult.getStartMillis()));
        test.getTest().setEndedTime(getTime(testResult.getEndMillis()));

        for (String group : testResult.getMethod().getGroups()) {
            test.assignCategory(group);
        }

        if (testStatus == ITestResult.FAILURE) {
            if (driver != null) {
                captureScreenshot(driver, testName);
            }
            test.log(LogStatus.FAIL, "TEST FAILED: " + testName);
            test.log(LogStatus.FAIL, testResult.getThrowable());

        } else if (testStatus == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "TEST SKIPPED: " + testName);
        } else if (testStatus == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "TEST PASSED: " + testName);
        }

        ExtentTestManager.endTest();
        extent.flush();
    }

    // endregion

    // region Selenium API
    public WebElement getVisibleElement(By by) {
        try {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver.findElement(by);
    }

    public WebElement getClickableElement(By by) {
        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver.findElement(by);

    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);

        fluentWait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    public String getTrimmedElementText(WebElement element) {
        String text = "";
        fluentWait.until(ExpectedConditions.visibilityOf(element));

        text = element.getText().trim();

        if (text.equals("")) {
            text = element.getAttribute("innerHTML").trim();
        }

        return text;
    }

    public void clickOnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void clearSendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
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
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void switchToParentFrame() {
        driver.switchTo().defaultContent();
    }

    public void switchToFrameByElement(WebElement frame) {
        driver.switchTo().frame(frame);
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

    // region JavaScriptExecutor Methods
    public void jsClickOnElement(WebElement element) {
        jsDriver.executeScript("arguments[0].click();", element);
    }

    public void safeClickOnElement(WebElement element) {
        try {
            clickOnElement(element);
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            System.out.println("Unable to click - trying again");
            jsClickOnElement(element);
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Unable to locate element - check element locator and ensure element is being made available");
        } catch (ElementNotVisibleException e) {
            jsClickOnElement(element);
        }
    }

    public WebElement setElementAttributeValue(String attribute, String value, By by) {
        jsDriver.executeScript("arguments[0].setAttribute('" + attribute + "', '" + value + "')", driver.findElement(by));

        return driver.findElement(by);
    }

    // endregion

    // endregion

    // region Helper Methods
    private static void driverInit(String browser, long explicit_timeout, long fluent_timeout, long polling_interval) {
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

        WebDriverListener listener = new DriverEventListener();
        driver = new EventFiringDecorator(listener).decorate(driver);
        jsDriver = (JavascriptExecutor) (driver);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(explicit_timeout));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(fluent_timeout))
                .pollingEvery(Duration.ofMillis(polling_interval))
                .ignoring(Exception.class);
    }

    private static void captureScreenshot(WebDriver driver, String testName) {
        String absPath = System.getProperty("user.dir");
        String screenshotFileName = "screenshot_" + testName + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + screenshotFileName);

        try {
            FileHandler.copy(screenshot, screenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }
    }

    private static void captureFullScreenshot(WebDriver driver, String testName) {
        String absPath = System.getProperty("user.dir");
        String fullScreenshotFileName = "full_screenshot_" + testName + ".png";

        File fullScreenshot = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        File fullScreenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + fullScreenshotFileName);

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
