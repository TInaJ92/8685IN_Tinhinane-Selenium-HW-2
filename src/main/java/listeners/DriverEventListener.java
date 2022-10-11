package listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class DriverEventListener implements WebDriverListener {

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {

    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {

    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

    }

    @Override
    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {

    }

    @Override
    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.printf("Navigating to: %s%n", url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.printf("Successfully navigated to page: %s%n", url);
    }

    @Override
    public void beforeGetCurrentUrl(WebDriver driver) {

    }

    @Override
    public void afterGetCurrentUrl(String result, WebDriver driver) {

    }

    @Override
    public void beforeGetTitle(WebDriver driver) {
        System.out.println("Attempting to get page title");
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        System.out.printf("Page title: %s%n", result);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.printf("Attempting to locate element using: %s%n", locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.printf("Successfully located element using: %s%n", locator.toString());
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        System.out.printf("Attempting to locate elements using: %s%n", locator.toString());
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.printf("Successfully located elements using: %s%n", locator.toString());
    }

    @Override
    public void beforeGetPageSource(WebDriver driver) {

    }

    @Override
    public void afterGetPageSource(WebDriver driver, String result) {

    }

    @Override
    public void beforeClose(WebDriver driver) {
        System.out.println("Closing browser session");
    }

    @Override
    public void afterClose(WebDriver driver) {
        System.out.println("Successfully closed browser session");
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        System.out.println("Attempting to quit driver executable");
    }

    @Override
    public void afterQuit(WebDriver driver) {
        System.out.println("Successfully quit driver executable");
    }

    @Override
    public void beforeGetWindowHandles(WebDriver driver) {
        System.out.println("Attempting to get all current window handles");
    }

    @Override
    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
        System.out.println("Successfully retrieved all window handles");
        result.forEach(System.out::println);
    }

    @Override
    public void beforeGetWindowHandle(WebDriver driver) {
        System.out.println("Attempting to get current window handle");
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        System.out.printf("Successfully retrieved current window handle: %s%n", result);
    }

    @Override
    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        System.out.printf("Attempting to execute javascript: %n%s%nUsing args: %s%n", script, Arrays.toString(args));
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        System.out.printf("Successfully executed javascript: %n%s%nResults: %s%n", script, result);
    }

    @Override
    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {

    }

    @Override
    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {

    }

    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {

    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {

    }

    @Override
    public void beforeResetInputState(WebDriver driver) {

    }

    @Override
    public void afterResetInputState(WebDriver driver) {

    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {

    }

    @Override
    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.printf("Attempting to click on element with tag: %s%n(Is displayed: %s)%n", element.getTagName(), element.isDisplayed());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Successfully clicked on element");
    }

    @Override
    public void beforeSubmit(WebElement element) {

    }

    @Override
    public void afterSubmit(WebElement element) {

    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.printf("Attempting to send keys \"%s\" to element with tag: %s%n", Arrays.toString(keysToSend), element.getTagName());
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.printf("Successfully sent keys \"%s\" to element", Arrays.toString(keysToSend));
    }

    @Override
    public void beforeClear(WebElement element) {
        System.out.printf("Attempting to clear text from element with tag: %s%n", element.getTagName());
    }

    @Override
    public void afterClear(WebElement element) {
        System.out.println("Successfully cleared text from element");
    }

    @Override
    public void beforeGetTagName(WebElement element) {

    }

    @Override
    public void afterGetTagName(WebElement element, String result) {

    }

    @Override
    public void beforeGetAttribute(WebElement element, String name) {

    }

    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {

    }

    @Override
    public void beforeIsSelected(WebElement element) {

    }

    @Override
    public void afterIsSelected(WebElement element, boolean result) {

    }

    @Override
    public void beforeIsEnabled(WebElement element) {

    }

    @Override
    public void afterIsEnabled(WebElement element, boolean result) {

    }

    @Override
    public void beforeGetText(WebElement element) {

    }

    @Override
    public void afterGetText(WebElement element, String result) {

    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {

    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {

    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {

    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {

    }

    @Override
    public void beforeIsDisplayed(WebElement element) {

    }

    @Override
    public void afterIsDisplayed(WebElement element, boolean result) {

    }

    @Override
    public void beforeGetLocation(WebElement element) {

    }

    @Override
    public void afterGetLocation(WebElement element, Point result) {

    }

    @Override
    public void beforeGetSize(WebElement element) {

    }

    @Override
    public void afterGetSize(WebElement element, Dimension result) {

    }

    @Override
    public void beforeGetCssValue(WebElement element, String propertyName) {

    }

    @Override
    public void afterGetCssValue(WebElement element, String propertyName, String result) {

    }

    @Override
    public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args) {

    }

    @Override
    public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {

    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {

    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, URL url) {

    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, URL url) {

    }

    @Override
    public void beforeBack(WebDriver.Navigation navigation) {

    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {

    }

    @Override
    public void beforeForward(WebDriver.Navigation navigation) {

    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {

    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {

    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {

    }

    @Override
    public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {

    }

    @Override
    public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeAccept(Alert alert) {

    }

    @Override
    public void afterAccept(Alert alert) {

    }

    @Override
    public void beforeDismiss(Alert alert) {

    }

    @Override
    public void afterDismiss(Alert alert) {

    }

    @Override
    public void beforeGetText(Alert alert) {

    }

    @Override
    public void afterGetText(Alert alert, String result) {

    }

    @Override
    public void beforeSendKeys(Alert alert, String text) {

    }

    @Override
    public void afterSendKeys(Alert alert, String text) {

    }

    @Override
    public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args) {

    }

    @Override
    public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {

    }

    @Override
    public void afterAddCookie(WebDriver.Options options, Cookie cookie) {

    }

    @Override
    public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {

    }

    @Override
    public void afterDeleteCookieNamed(WebDriver.Options options, String name) {

    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {

    }

    @Override
    public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {

    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        System.out.println("Attempting to delete all cookies");
    }

    @Override
    public void afterDeleteAllCookies(WebDriver.Options options) {
        System.out.println("Successfully deleted all cookies");
    }

    @Override
    public void beforeGetCookies(WebDriver.Options options) {

    }

    @Override
    public void afterGetCookies(WebDriver.Options options, Set<Cookie> result) {

    }

    @Override
    public void beforeGetCookieNamed(WebDriver.Options options, String name) {

    }

    @Override
    public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result) {

    }

    @Override
    public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args) {

    }

    @Override
    public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {

    }

    @Override
    public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args) {

    }

    @Override
    public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeGetSize(WebDriver.Window window) {

    }

    @Override
    public void afterGetSize(WebDriver.Window window, Dimension result) {

    }

    @Override
    public void beforeSetSize(WebDriver.Window window, Dimension size) {

    }

    @Override
    public void afterSetSize(WebDriver.Window window, Dimension size) {

    }

    @Override
    public void beforeGetPosition(WebDriver.Window window) {

    }

    @Override
    public void afterGetPosition(WebDriver.Window window, Point result) {

    }

    @Override
    public void beforeSetPosition(WebDriver.Window window, Point position) {

    }

    @Override
    public void afterSetPosition(WebDriver.Window window, Point position) {

    }

    @Override
    public void beforeMaximize(WebDriver.Window window) {
        System.out.println("Attempting to maximize window");
    }

    @Override
    public void afterMaximize(WebDriver.Window window) {
        System.out.println("Successfully maximized window");
    }

    @Override
    public void beforeFullscreen(WebDriver.Window window) {

    }

    @Override
    public void afterFullscreen(WebDriver.Window window) {

    }
}
