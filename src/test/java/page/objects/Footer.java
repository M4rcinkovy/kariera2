package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

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

  /*  @FindBy(xpath = "//a[contains(@data-elementname, 'Quality Excites')]")
    private WebElement qualityExcitesLogoFooter;*/

    @FindBy(xpath = "//a[contains(@href, 'https://www.meetup.com/pl-PL/Quality-Meetup/')]")
    private WebElement qualityExcitesMeetUpLogoFooter;

 /*   @FindBy(xpath = "//img[contains(@alt, 'DPTO')]")
    private WebElement dptoLogoFooter;*/

    @FindBy(className = "s-Footer__Address__Text")
    private WebElement addressAndLocalizationFooterInfo;

    @FindBy(className = "s-Footer__Address__ShowMap")
    private WebElement addressFooterShowMapButton;

    @FindBy(className = "s-Footer__Address__Image")
    private WebElement addressFooterFPPicture;

    @FindBy(className = "o-Map__Close")
    private WebElement crossButtonOnOpenGoogleMap;

    @FindBy(className = "o-Map__Url")
    private WebElement showOnGoogleMapSite;

    public Footer() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Czy pokazuje sie w stopce 'Strona Biznesowa'")
    public Footer assertIsStronaBiznesowaFooterLink() {
        WaitForElement.waitUntilElementIsVisible(stronaBiznesowaFooterButton);
        assertThat(stronaBiznesowaFooterButton).isDisplayed();
        return this;
    }

    @Step("Czy pokazuje sie w stopce 'Blog Biznesowy'")
    public Footer assertIsBlogBiznesowyFooterLink() {
        WaitForElement.waitUntilElementIsVisible(blogBiznesowyFooterButton);
        assertThat(blogBiznesowyFooterButton).isDisplayed();
        return this;
    }

    @Step("Czy udalo sie pobrac tekst z 'mailto' ktory otwiera lokalnie przypisany program mailowy")
    public  Footer emailFromFooter(String  getWhiteTextEmail) {
        log().info("Pobrano maila kontaktowego ze stopki, ktory brzmi: '{}'", getWhiteTextEmail);
        WaitForElement.waitUntilElementIsVisible(mailtoEmailButton);
        AssertWebElement.assertThat(mailtoEmailButton).isDisplayed().hasText(getWhiteTextEmail);
        return this;
    }

    @Step("Czy adres email 'kopiuj do schowka' wyswietla sie na stronie")
    public Footer assertIsKopiujDoSchowka() {
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        assertThat(emailCopyToClipboard).isDisplayed();
        return this;
    }

    @Step("Pobrano tekst z zaslonietego buttona emailowego")
    public  Footer kopiujDoSchowkaButton(String getTextFromCopyToClipboard) {
        log().info("Pobrano tekst z zaslonietego buttona: '{}'", getTextFromCopyToClipboard);
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        AssertWebElement.assertThat(emailCopyToClipboard).isDisplayed().hasText(getTextFromCopyToClipboard);
        return this;
    }

    @Step("Kliknieto w przycisk 'skopiuj do schowka' - uzytkownik ma mail w pamieci podrecznej")
    public Footer kopiujDoSchowkaButtonClick() {
        WaitForElement.waitUntilElementIsVisible(emailCopyToClipboard);
        emailCopyToClipboard.click();
        log().info("Kliknięto w przycisk CopyToClipboard");
        return this;
    }

    @Step("Pobrano tekst z zaslonietego buttona 'skopiowano'")
    public  Footer skopiowanoButton(String getTextFromSkopiowano) {
        log().info("Pobrano tekst z zaslonietego buttona mailowego: '{}'", getTextFromSkopiowano);
        WaitForElement.waitUntilElementIsVisible(emailClipboardTextCopied);
        AssertWebElement.assertThat(emailClipboardTextCopied).isDisplayed().hasText(getTextFromSkopiowano);
        return this;
    }

    @Step("Czy ukryty Przycisk '...zobacz' przy nr. telefonu sie pokazuje")
    public Footer assertIsPhoneZobaczButton() {
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        assertThat(phoneNumberHideButton).isDisplayed();
        return this;
    }

    @Step("Kliknięto w przycisk, pod którym schowany jest numer telefonu i Odkryto go w calosci")
    public Footer clickOnZobaczPhoneButton() {
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        phoneNumberHideButton.click();
        log().info("Kliknięto w przycisk, pod którym schowany jest numer telefonu i Odkryto go w calosci");
        return this;
    }

    @Step("Pobrano tekst z zasłoniętego buttona nr. telefonicznego")
    public  Footer takeHideNumberText(String hideNumberButtonText) {
        log().info("Pobrano tekst z zaslonietego buttona nr telefonu: '{}'", hideNumberButtonText);
        WaitForElement.waitUntilElementIsVisible(phoneNumberHideButton);
        AssertWebElement.assertThat(phoneNumberHideButton).isDisplayed().hasText(hideNumberButtonText);
        return this;
    }

    @Step("Czy Pobrano poprawny numer telefonu")
    public  Footer takeShowNumberText(String showAllNumberButton) {
        log().info("Czy Pobrano poprawny numer telefonu: '{}'", showAllNumberButton);
        WaitForElement.waitUntilElementIsVisible(phoneCallButton);
        AssertWebElement.assertThat(phoneCallButton).isDisplayed().hasText(showAllNumberButton);
        return this;
    }

    @Step("Czy caly numer telefonu jest widoczny")
    public Footer assertIsPhoneAllNumberExpand() {
        WaitForElement.waitUntilElementIsVisible(phoneCallButton);
        assertThat(phoneCallButton).isDisplayed();
        return this;
    }

    @Step("Czy Pobrano napisy przy mapce")
    public  Footer addressLocationFP(String addressTextLocationFooter) {
        log().info("Czy Pobrano napisy przy mapce: '{}'", addressTextLocationFooter);
        WaitForElement.waitUntilElementIsVisible(addressAndLocalizationFooterInfo);
        AssertWebElement.assertThat(addressAndLocalizationFooterInfo).isDisplayed().hasText(addressTextLocationFooter);
        return this;
    }

    @Step("Czy ZDJECIE JEST WIDCOZNE przed kliknieciem w pokazanie sie mapki")
    public Footer assertIsPictureBeforeMap() {
        WaitForElement.waitUntilElementIsVisible(addressFooterFPPicture);
        assertThat(addressFooterFPPicture).isDisplayed();
        return this;
    }

    @Step("Kliknięto w przycisk Zobacz na mapie")
    public Footer clickOnZobaczNaMapieButton() {
        WaitForElement.waitUntilElementIsVisible(addressFooterShowMapButton);
        addressFooterShowMapButton.click();
        log().info("Kliknięto w przycisk Zobacz na mapie");
        return this;
    }

    @Step("Kliknięto w KRZYZYK na odsloniętej mapie")
    public Footer clickOnCrossOnMapButton() {
        WaitForElement.waitUntilElementIsVisible(crossButtonOnOpenGoogleMap);
        crossButtonOnOpenGoogleMap.click();
        log().info("Kliknięto w KRZYZYK na odsloniętej mapie");
        return this;
    }

    /*@Step("Strona Quality Excites została wyświetlona po kliknięciu w buttona na footerze")
    public Footer clickOnQualityExcitesButton() {
        WaitForElement.waitUntilElementIsVisible(qualityExcitesLogoFooter);
        qualityExcitesLogoFooter.click();
        log().info("Strona Quality Excites została wyświetlona po kliknięciu w buttona na footerze");
        return this;
    }*/

    @Step("Strona Quality MeetUp została wyświetlona po kliknięciu w buttona na footerze")
    public Footer clickOnQualityExcitesMeetUpButton(String getTextFromHrefQualityMeetUp) {
        log().info("Strona Quality MeetUp ma adres: '{}'", getTextFromHrefQualityMeetUp);
        WaitForElement.waitUntilElementIsVisible(qualityExcitesMeetUpLogoFooter);
        assertThat(qualityExcitesMeetUpLogoFooter).isDisplayed().hasText("getTextFromHrefQualityMeetUp");
        return this;
    }

   /* @Step("Strona DPTO została wyświetlona po kliknięciu w buttona na footerze")
    public Footer clickOnDPTOButton() {
        WaitForElement.waitUntilElementIsClickable(dptoLogoFooter);
        dptoLogoFooter.click();
        log().info("Strona DPTO została wyświetlona po kliknięciu w buttona na footerze");
        return this;
    }*/

    @Step("Kliknięto w przycisk kierującego na Stronę googleMaps w nowej karcie")
    public Footer showOnGoogleMap() {
        WaitForElement.waitUntilElementIsVisible(showOnGoogleMapSite);
        showOnGoogleMapSite.click();
        log().info("Kliknięto w przycisk kierującego na googleMaps");
        return this;
    }
}
