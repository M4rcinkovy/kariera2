package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.Footer;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class FooterUse extends TestBase {

    @Test
    public void asUserCheckIfFooterWorkCorrectly() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .assertIsCookieBarShow()
                .clickOnCookieButtonPopUp();

        Footer footer = new Footer();
        footer
              .assertIsKopiujDoSchowka()
              .assertIsPhoneZobaczButton()
              .assertIsPhoneAllNumberExpand()
              .assertIsPictureBeforeMap()
              .assertIsStronaBiznesowaFooterLink()
              .assertIsBlogBiznesowyFooterLink()
              .clickOnZobaczPhoneButton()
              .takeHideNumberText()
              .takeShowNumberText()
              .emailFromFooter()
              .kopiujDoSchowkaButton()
              .kopiujDoSchowkaButtonClick()
              .skopiowanoButton()
              .addressLocationFP()
              .clickOnQualityExcitesButton();

        DriverUtils.backToPage();

        footer.clickOnQualityExcitesMeetUpButton();
        DriverUtils.backToPage();

        footer.clickOnDPTOButton();
        DriverUtils.backToPage();

        footer
                .clickOnZobaczNaMapieButton()
                .clickOnCrossOnMapButton()
                .clickOnZobaczNaMapieButton()
                .showOnGoogleMap();
    }
}