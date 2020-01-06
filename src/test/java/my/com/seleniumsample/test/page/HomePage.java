package my.com.seleniumsample.test.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'https://www.petronas.com/about-us')]")
    @CacheLookup
    private WebElement moreInfoAboutUsBtn;

    @FindBy(xpath = "//div[@id='app']/div[3]/div/div/div[2]/div/div/div/div[2]/div/div/div[2]")
    @CacheLookup
    private WebElement aboutUsDiv;


    public void acceptCookies(){
        super.acceptCookies();
    }


    public void clickAboutUs() {
        moveToElement(aboutUsDiv);
//        scrollTo(true, 1300);
        waitForElementToVisible(moreInfoAboutUsBtn,15);
        moreInfoAboutUsBtn.click();
    }

    public String menuAboutUS(){
        return moreInfoAboutUsBtn.getText();
    }
}
