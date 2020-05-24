package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class Footer extends BasePage{

    @FindBy(id = "menu-item-599")
    private WebElement stronaBiznesowaFooterButton;

    @FindBy(id = "menu-item-12400")
    private WebElement blogBiznesowyFooterButton;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Email - click')]")
    private WebElement mailtoEmailButton;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Email – copy to clipboard')]")
    private WebElement emailCopyToClipboard;

    @FindBy(xpath = "//span[contains(@class, 'Text--Copied')]")
    private WebElement emailClipboardTextCopied;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Phone - view')]")
    private WebElement phoneNumberHideButton;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Phone - call')]")
    private WebElement phoneCallButton;

    @FindBy(xpath = "//a[contains(@data-elementname, 'Quality Excites')]")
    private WebElement qualityExcitesLogoFooter;

    @FindBy(xpath = "//img[contains(@alt, 'Quality Meetup')]")
    private WebElement qualityExcitesMeetUpLogoFooter;

    @FindBy(xpath = "//img[contains(@alt, 'DPTO')]")
    private WebElement dptoLogoFooter;

    @FindBy(className = "s-Footer__Address__Text")
    private WebElement addressFooterField;

    @FindBy(className = "s-Footer__Address__ShowMap")
    private WebElement addressFooterShowMap;

    @FindBy(className = "s-Footer__Address__Image")
    private WebElement addressFooterFPPicture;

    @FindBy(className = "o-Map__Close")
    private WebElement crossButtonOnGoogleMap;

    @FindBy(className = "o-Map__Url")
    private WebElement showOnGoogleMap;

    public Footer() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean stronaBiznesowa() {
        WaitForElement.waitUntilElementIsVisible(stronaBiznesowaFooterButton);
        boolean isStronaBizButtonShow = stronaBiznesowaFooterButton.isDisplayed();
        log().info("Czy pokazuje sie w stopce 'Strona Biznesowa': {}", isStronaBizButtonShow);
        return isStronaBizButtonShow;
    }

    public boolean blogBiznesowy() {
        WaitForElement.waitUntilElementIsVisible(blogBiznesowyFooterButton);
        boolean isBlogBiznesowy = blogBiznesowyFooterButton.isDisplayed();
        log().info("Czy pokazuje sie w stopce 'Blog Biznesowy': {}", isBlogBiznesowy);
        return isBlogBiznesowy;
    }

    /*public boolean emailFooterSystemPopUp() {
        WaitForElement.waitUntilElementIsVisible(emailFooterField);
        boolean isEmailProper = emailFooterField.isDisplayed();
        log().info("Czy EMAIL (adres) jest widoczny, i czy mozna w niego kliknac: {}", isEmailProper);
        return isEmailProper;
    }*/

    public boolean kopiujDoSchowka() {
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        boolean isKopiujDoSchowkaProper = emailCopyToClipboard.isDisplayed();
        log().info("Czy adres email 'kopiuj do schowka' wyswietla sie na stronie: {}", isKopiujDoSchowkaProper);
        return isKopiujDoSchowkaProper;
    }

    public boolean phoneZobaczButton() {
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        boolean isButtonShow = phoneNumberHideButton.isDisplayed();
        log().info("Czy ukryty Przycisk '...zobacz' przy nr. telefonu sie pokazuje: {}", isButtonShow);
        return isButtonShow;
    }

    public  Footer emailFromFooter() {
        WaitForElement.waitUntilElementIsVisible(mailtoEmailButton);
        String  getWhiteTextEmail = mailtoEmailButton.getText();
        log().info("Pobrano tekst z zaslonietego buttona: '{}'", getWhiteTextEmail);
        return this;
    }

    public  Footer kopiujDoSchowkaButton() {
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        String  getTextFromCopyToClipboard = emailCopyToClipboard.getText();
        log().info("Pobrano tekst z zaslonietego buttona: '{}'", getTextFromCopyToClipboard);
        return this;
    }

    public Footer kopiujDoSchowkaButtonClick() { //booleana zrobic
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        emailCopyToClipboard.click();
        log().info("Kliknięto w przycisk CopyToClipboard");
        return this;
    }

    public  Footer skopiowanoButton() {
        WaitForElement.waitUntilElementIsVisible(emailClipboardTextCopied);
        String  getTextFromSkopiowano = emailClipboardTextCopied.getText();
        log().info("Pobrano tekst z zaslonietego buttona: '{}'", getTextFromSkopiowano);
        return this;
    }

    public Footer clickOnZobaczPhoneButton() {
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        phoneNumberHideButton.click();
        log().info("Kliknięto w przycisk, pod którym schowany jest numer telefonu i Odkryto go w calosci");
        return this;
    }

    public  Footer takeHideNumberText() {
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        String  hideNumberButton = phoneNumberHideButton.getText();
        log().info("Pobrano tekst z zaslonietego buttona: '{}'", hideNumberButton);
        return this;
    }

    public  Footer takeShowNumberText() {
        WaitForElement.waitUntilElementIsVisible(phoneCallButton);
        String  openNumberButton = phoneCallButton.getText();
        log().info("Czy Pobrano poprawny numer telefonu: '{}'", openNumberButton);
        return this;
    }

    public boolean phoneAllNumberExpand() {
        WaitForElement.waitUntilElementIsVisible(phoneCallButton);
        boolean isPhoneNumberExpand = phoneCallButton.isDisplayed();
        log().info("Czy caly numer telefonu jest widoczny: {}", isPhoneNumberExpand);
        return isPhoneNumberExpand;
    }

    public  Footer takeWords() {
        WaitForElement.waitUntilElementIsVisible(addressFooterField);
        String  texts = addressFooterField.getText();
        log().info("Czy Pobrano napisy przy mapce: '{}'", texts);
        return this;
    }

    public boolean pictureBeforeMap() {
        WaitForElement.waitUntilElementIsVisible(addressFooterFPPicture);
        boolean isPictureCloseShow = addressFooterFPPicture.isDisplayed();
        log().info("Czy ZDJECIE JEST WIDCOZNE przed kliknieciem w pokazanie sie mapki: {}", isPictureCloseShow);
        return isPictureCloseShow;
    }

    public Footer clickOnZobaczNaMapieButton() {
        WaitForElement.waitUntilElementIsVisible(addressFooterShowMap);
        addressFooterShowMap.click();
        log().info("Kliknięto w przycisk Zobacz na mapie");
        return this;
    }

    public Footer clickOnCrossOnMapButton() {
        WaitForElement.waitUntilElementIsVisible(crossButtonOnGoogleMap);
        crossButtonOnGoogleMap.click();
        log().info("Kliknięto w KRZYZYK na odsloniętej mapie");
        return this;
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

    public Footer showOnGoogleMap() {
        WaitForElement.waitUntilElementIsVisible(showOnGoogleMap);
        showOnGoogleMap.click();
        log().info("Kliknięto w przycisk kierującego na googleMaps");
        return this;
    }
}
