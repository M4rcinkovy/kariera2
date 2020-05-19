package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.Footer;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertTrue;

public class FooterUse extends TestBase {

    @Test
    public void asUserCheckIfFooterWorkCorrectly() {
        //DriverUtils.navigateToPage(APPLICATION_URL);

        Footer footer = new Footer();
        assertTrue(footer.stronaBiznesowa());
        assertTrue(footer.blogBiznesowy());
        assertTrue(footer.emailFooterSystemPopUp());
        assertTrue(footer.kopiujDoSchowka());
        assertTrue(footer.phoneZobaczButton());
        assertTrue(footer.phoneAllNumberExpand());

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .assertIsCookieBarShow()
                .clickOnCookieButtonPopUp();

        footer.clickOnQualityExcitesButton();
        DriverUtils.backToPage();

        footer.clickOnQualityExcitesMeetUpButton();
        DriverUtils.backToPage();

        footer.clickOnDPTOButton();
        DriverUtils.backToPage();
        
    }
}