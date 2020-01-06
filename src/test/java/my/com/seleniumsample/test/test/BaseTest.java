package my.com.seleniumsample.test.test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import my.com.seleniumsample.test.config.DriverConfig;
import my.com.seleniumsample.test.config.TestConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Test
@Listeners({ExtentITestListenerClassAdapter.class})
@ContextConfiguration(classes = {DriverConfig.class, TestConfig.class})
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@DependsOn("setupWebDriver")
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebDriver driver;

    static final String PAGE_URL = "https://www.petronas.com/";

    protected Assertion hardAssert = new Assertion();
    protected SoftAssert softAssert = new SoftAssert();

    @AfterMethod
    public synchronized void scrShot(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                System.out.println("[DEBUG] A Test have fail");
                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                TakesScreenshot ts = (TakesScreenshot) driver;
                File scrFile = ts.getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir") + "\\test-output\\HtmlReport\\" + dateName + ".png";
                System.out.println("[DEBUG]IMAGE PATH= " + path);
                try {
                    File destination = new File(path);
                    FileUtils.copyFile(scrFile, destination);
                    ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod",
                            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ITestResult.SKIP:
                ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
                break;
            default:
                break;
        }

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("AfterClass");
        }
    }

}
