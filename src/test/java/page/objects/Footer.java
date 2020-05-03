package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class Footer{

    private Logger logger = LogManager.getLogger(Footer.class);

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

    @FindBy(xpath = "//a[contains(@data-elementname, 'Quality_Excites')]")
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
        logger.info("Czy pokazuje sie w stopce 'Strona Biznesowa': {}", isStronaBizButtonShow);
        return isStronaBizButtonShow;
    }

    public boolean blogBiznesowy() {
        WaitForElement.waitUntilElementIsVisible(blogBiznesowy);
        boolean isBlogBiznesowy = blogBiznesowy.isDisplayed();
        logger.info("Czy pokazuje sie w stopce 'Blog Biznesowy': {}", isBlogBiznesowy);
        return isBlogBiznesowy;
    }

    public boolean emailFooterSystemPopUp() {
        WaitForElement.waitUntilElementIsVisible(emailFooterField);
        boolean isEmailProper = emailFooterField.isDisplayed();
        logger.info("Czy EMAIL (adres) jest widoczny, i czy mozna w niego kliknac: {}", isEmailProper);
        return isEmailProper;
    }

    public boolean kopiujDoSchowka() {
        WaitForElement.waitUntilElementIsVisible(emailFooterCopyData);
        boolean isKopiujDoSchowkaProper = emailFooterCopyData.isDisplayed();
        logger.info("Czy adres email 'kopiuj do schowka' wyswietla sie na stronie: {}", isKopiujDoSchowkaProper);
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
        logger.info("Czy ukryty Phone number sie pokazuje: {}", isButtonShow);
        return isButtonShow;
    }

    public Footer clickOnZobaczPhoneButton() {
        WaitForElement.waitUntilElementIsVisible(qualityExcitesLogoFooter);
        qualityExcitesLogoFooter.click();
        logger.info("Czy klikniecie ukrytego 'Phone Number' dziala i odslania numer: {}", qualityExcitesLogoFooter);
        return this;
    }

    public boolean phoneAllNumberExpand() {
        WaitForElement.waitUntilElementIsVisible(phoneViewOpenField);
        boolean isPhoneNumberExpand = phoneViewOpenField.isDisplayed();
        logger.info("Czy caly numer telefonu jest widoczny: {}", isPhoneNumberExpand);
        return isPhoneNumberExpand;
    }

}
