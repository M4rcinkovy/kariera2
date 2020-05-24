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
              .emailFromFooter("praca@future-processing.com")
              .kopiujDoSchowkaButton("kopiuj do schowka")
              .kopiujDoSchowkaButtonClick()
              .skopiowanoButton("skopiowano")
              .clickOnZobaczPhoneButton()
              .takeHideNumberText("...zobacz")
              .takeShowNumberText("+48 32 461 23 00")
              .addressLocationFP("Future Processing S.A.\n" +
                      "ul. Bojkowska 37a\n" +
                      "44-100 Gliwice\n" +
                      "Zobacz na mapie")
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