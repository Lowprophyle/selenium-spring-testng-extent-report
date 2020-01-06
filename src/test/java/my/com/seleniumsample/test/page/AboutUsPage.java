package my.com.seleniumsample.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class AboutUsPage extends BasePage{

    @FindBy(className = "landing-section-title")
    private WebElement landingSectionTitle;


    public String titleText(){
       return landingSectionTitle.getAttribute("innerText");
    }
}
