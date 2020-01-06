package my.com.seleniumsample.test.test;
import my.com.seleniumsample.test.page.AboutUsPage;
import my.com.seleniumsample.test.page.HomePage;
import my.com.seleniumsample.test.page.MenuPage;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FirstTest extends BaseTest {

    @Autowired
    private HomePage homePage;
    @Autowired
    private MenuPage menuPage;
    @Autowired
    private AboutUsPage aboutUsPage;

    @Test
    public void Petronas_Menu() {
        driver.get(PAGE_URL);
        driver.manage().window().setSize(new Dimension(1366, 768));
        homePage.acceptCookies();

//        softAssert.assertEquals(homePage.menuText(), "MENU");
        homePage.clickMenu();

        softAssert.assertEquals(menuPage.aboutUsText(),"ABOUT US");
        softAssert.assertEquals(menuPage.ourBusinessText(),"OUR BUSINESS");
        softAssert.assertEquals(menuPage.sustainabilityText(),"SUSTAINABILITY");
        softAssert.assertEquals(menuPage.ourBrandText(),"OUR BRAND");
        softAssert.assertEquals(menuPage.investorRelationsText(),"INVESTOR RELATIONS");
        softAssert.assertEquals(menuPage.innovationText(),"INNOVATION");
        softAssert.assertEquals(menuPage.joinUsText(),"JOIN US");
        softAssert.assertEquals(menuPage.mediaText(),"MEDIA");
        softAssert.assertEquals(menuPage.contactUsText(),"CONTACT US");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "Petronas_Menu")
    public void Navigate_to_About_us() throws InterruptedException {

        driver.get(PAGE_URL);
        driver.manage().window().setSize(new Dimension(1366, 768));
        homePage.acceptCookies();
        homePage.clickAboutUs();
        Assert.assertEquals(aboutUsPage.titleText(),"MALAYSIA’S FULLY INTEGRATED PETROLEUM CORPORATIO");

    }
}
