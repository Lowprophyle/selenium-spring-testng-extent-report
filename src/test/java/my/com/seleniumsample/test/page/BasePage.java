package my.com.seleniumsample.test.page;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public abstract class BasePage {

    private static final int TIMEOUT = 3;
    private static final int POLLING = 200;
    private boolean acceptNextAlert = true;

    @Autowired
    private WebDriver driver;

    private WebDriverWait wait;

//    @FindBy(css = "button.navbar-toggle")
    @FindBy(css = "button.navbar-toggler")
    @CacheLookup
    private WebElement menuBtn;

    @PostConstruct
    public void postConstructor() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }


    // Common Methods
// --------------------------------------------------.
    @FindBy(css = "button.btn.btn-accept")
    private WebElement acceptBtn;

    protected void acceptCookies() {
        try {
            acceptBtn.click();
        } catch (Exception e) {
            System.out.println("No cookies popup");
        }
        System.out.println("Cookies Accepted");
    }

    public void clickMenu() {
        menuBtn.click();
    }

    public String menuText() {
        return menuBtn.getText();
    }


// Common Utils
// --------------------------------------------------.


    protected void waitForElementToVisible(WebElement locator, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

//    protected void waitForElementToDisappear(WebElement locator) {
//        wait.until(ExpectedConditions.invisibilityOfAllElements(Arrays.asList(locator)));
//    }
//
//    protected void waitForTextToDisappear(By locator, String text) {
//        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
//    }

    protected void moveToElement(WebElement element) {
//        https://github.com/SeleniumHQ/selenium/issues/4148
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName();
        System.out.println(browserName);
        if (browserName.equals("firefox")) {
            System.out.println("FIREFOX JS Running");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void scrollTo(boolean direction, int pixel) {
//        true scrollUp,   false scrollDown
        String pixelText = "0";
        if (!direction) {
            pixelText = "-" + pixel;
        }
        String arguments = "\"window.scrollBy(0," + pixelText + ")\"";
        ((JavascriptExecutor) driver).executeScript(arguments, "");
    }


    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
// --------------------------------------------------.

}
