package my.com.seleniumsample.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MenuPage extends BasePage {

    private WebDriver driver;

//    @FindBy(linkText = "About Us")
    @FindBy(xpath = "//a[contains(text(),'About Us')]")
    private WebElement aboutUs;
    @FindBy(xpath = "//*/text()[normalize-space(.)='Our Business']/parent::*")
    private WebElement ourBusiness;
    @FindBy(xpath = "//a[contains(@href, '/our-brand')]")
    private WebElement ourBrand;
    @FindBy(xpath = "//*/text()[normalize-space(.)='Sustainability']/parent::*")
    private WebElement sustainability;
    @FindBy(xpath = "//a[contains(text(),\'Investor Relations\')]")
    private WebElement investorRelations;
    @FindBy(css = ".menu:nth-child(6) > .nav-item")
    private WebElement innovation;
    @FindBy(xpath = "//a[contains(text(),\'Join Us\')]")
    private WebElement joinUs;
    @FindBy(xpath = "//a[contains(text(),\'Media\')]")
    private WebElement media;
    @FindBy(xpath = "//a[contains(text(),\'Contact Us\')]")
    private WebElement contactUs;


    public String aboutUsText() {
        return aboutUs.getAttribute("innerText");
    }

    public String ourBusinessText() {
        return ourBusiness.getAttribute("innerText");
    }


    public String ourBrandText() {
        return ourBrand.getAttribute("innerText");
    }


    public String sustainabilityText() {
        return sustainability.getAttribute("innerText");
    }


    public String investorRelationsText() {
        return investorRelations.getAttribute("innerText");
    }


    public String innovationText() {
        return innovation.getAttribute("innerText");
    }


    public String joinUsText() {
        return joinUs.getAttribute("innerText");
    }


    public String mediaText() {
        return media.getAttribute("innerText");
    }


    public String contactUsText() {
        return contactUs.getAttribute("innerText");
    }
}


