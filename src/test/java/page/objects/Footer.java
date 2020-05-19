package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class Footer extends BasePage{

    @FindBy(id = "menu-item-599")
    private WebElement stronaBiznesowaField;

    @FindBy(id = "menu-item-12400")
    private WebElement blogBiznesowy;

    @FindBy(className = "o-ContactData__Link")
    private WebElement emailFooterField;

    @FindBy(className = "o-ContactData__Email__Copy")
    private WebElement emailFooterCopyData; // tu musze kliknac i pobrac napisy przed i po kliknieciu

    @FindBy(className = "o-ContactData__Phone__Content")
    private WebElement phoneViewOpenField;

    @FindBy(id = "o-ContactData__Phone__View")
    private WebElement phoneViewCloseField; //pobrac numer telefonu i czy jest wlasciwy w asercji

    @FindBy(xpath = "//a[contains(@data-elementname, 'Phone - view')]")
    private WebElement proba;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Quality Excites')]")
    private WebElement qualityExcitesLogoFooter;

    @FindBy(xpath = "//img[contains(@alt, 'Quality Meetup')]")
    private WebElement qualityExcitesMeetUpLogoFooter;

    @FindBy(xpath = "//img[contains(@alt, 'DPTO')]")
    private WebElement dptoLogoFooter;

    @FindBy(className = "s-Footer__Address__Text")
    private WebElement addressFooterField;

    @FindBy(className = "s-Footer__Address__Image")
    private WebElement addressFooterFPPicture;

    @FindBy(className = "s-Footer__Address__ShowMap")
    private WebElement addressFooterShowMap;

    @FindBy(id = "js-Map")
    private WebElement odslonietaMapaGoogle;

    @FindBy(className = "o-Map__Close")
    private WebElement crossButtonOnGoogleMap;

    @FindBy(className = "o-Map__Url")
    private WebElement showOnGoogleMap;

    public Footer() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean stronaBiznesowa() {
        WaitForElement.waitUntilElementIsVisible(stronaBiznesowaField);
        boolean isStronaBizButtonShow = stronaBiznesowaField.isDisplayed();
        log().info("Czy pokazuje sie w stopce 'Strona Biznesowa': {}", isStronaBizButtonShow);
        return isStronaBizButtonShow;
    }

    public boolean blogBiznesowy() {
        WaitForElement.waitUntilElementIsVisible(blogBiznesowy);
        boolean isBlogBiznesowy = blogBiznesowy.isDisplayed();
        log().info("Czy pokazuje sie w stopce 'Blog Biznesowy': {}", isBlogBiznesowy);
        return isBlogBiznesowy;
    }

    public boolean emailFooterSystemPopUp() {
        WaitForElement.waitUntilElementIsVisible(emailFooterField);
        boolean isEmailProper = emailFooterField.isDisplayed();
        log().info("Czy EMAIL (adres) jest widoczny, i czy mozna w niego kliknac: {}", isEmailProper);
        return isEmailProper;
    }

    public boolean kopiujDoSchowka() {
        WaitForElement.waitUntilElementIsVisible(emailFooterCopyData);
        boolean isKopiujDoSchowkaProper = emailFooterCopyData.isDisplayed();
        log().info("Czy adres email 'kopiuj do schowka' wyswietla sie na stronie: {}", isKopiujDoSchowkaProper);
        return isKopiujDoSchowkaProper;
    }

    /*public Footer clickOnKopiujDoSchowkaButton() {
        WaitForElement.waitUntilElementIsVisible(emailFooterCopyData);
        emailFooterCopyData.click();
        logger.info("Skopiowano wartosc 'Skopiuj do schowka': {}");
        return this;
    }*/

    public boolean phoneZobaczButton() {
        WaitForElement.waitUntilElementIsVisible(phoneViewCloseField);
        boolean isButtonShow = phoneViewCloseField.isDisplayed();
        log().info("Czy ukryty Phone number sie pokazuje: {}", isButtonShow);
        return isButtonShow;
    }

    public Footer clickOnZobaczPhoneButton() {
        WaitForElement.waitUntilElementIsVisible(phoneViewOpenField);
        phoneViewOpenField.click();
        log().info("Czy klikniecie ukrytego 'Phone Number' dziala i odslania numer: {}", qualityExcitesLogoFooter);
        return this;
    }

    public boolean phoneAllNumberExpand() {
        WaitForElement.waitUntilElementIsVisible(phoneViewOpenField);
        boolean isPhoneNumberExpand = phoneViewOpenField.isDisplayed();
        log().info("Czy caly numer telefonu jest widoczny: {}", isPhoneNumberExpand);
        return isPhoneNumberExpand;
    }

    public Footer clickOnQualityExcitesButton() {
        WaitForElement.waitUntilElementIsVisible(qualityExcitesLogoFooter);
        qualityExcitesLogoFooter.click();
        log().info("Czy mozna kliknac w Quality Excites logo: {}", qualityExcitesLogoFooter);
        return this;
    }

    public Footer clickOnQualityExcitesMeetUpButton() {
        WaitForElement.waitUntilElementIsVisible(qualityExcitesMeetUpLogoFooter);
        qualityExcitesMeetUpLogoFooter.click();
        log().info("Czy mozna kliknac w Quality MeetUp logo: {}", qualityExcitesMeetUpLogoFooter);
        return this;
    }

    public Footer clickOnDPTOButton() {
        WaitForElement.waitUntilElementIsVisible(dptoLogoFooter);
        dptoLogoFooter.click();
        log().info("Czy mozna kliknac w DPTO logo: {}", dptoLogoFooter);
        return this;
    }

}
