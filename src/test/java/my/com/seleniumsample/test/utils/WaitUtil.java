//package my.com.seleniumsample.test.utils;
//
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//
//import java.time.Duration;
//
//public class WaitUtil {
//    private static Wait<WebDriver> wait;
//    private final static int WAIT_TIMEOUT_IN_SECONDS = 30;
//    private final static int POLLING_RATE_IN_MILLISECONDS = 1000;
//
//    private static Wait<WebDriver> getWait(WebDriver driver) {
//        if (wait == null) {
//            wait = new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS))
//                    .pollingEvery(Duration.ofMillis(POLLING_RATE_IN_MILLISECONDS))
//                    .ignoring(NoSuchElementException.class)
//                    .ignoring(StaleElementReferenceException.class);
//        }
//        return wait;
//    }
//    public static WebElement waitUntilElementVisible(WebDriver driver,  WebElement element) {
//        getWait(driver).until(ExpectedConditions.visibilityOf(element));
//        return element;
//    }
//
//    public static WebElement waitUntilElementClickable(WebDriver driver, WebElement element) {
//        getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
//        return element;
//    }
//}
