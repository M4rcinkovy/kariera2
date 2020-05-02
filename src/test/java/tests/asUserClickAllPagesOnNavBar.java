package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertTrue;

public class asUserClickAllPagesOnNavBar extends TestBase {

    @Test
    public void asUserSwitchToAnotherPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .videoFieldIs()
                .isCookieShow()
                .clickOnCookieButtonPopUp()
                .isFormIsActive()
                .isImageOneVisible()
                .isImageTwoVisible()
                .clickOnOfertyPracy()
                .clickOnONas()
                .clickOnJakPracujemy()
                .clickOnBlogTechniczny()
                .clickOnFAQ()
                .clickOnKONTAKT()
                .clickOnStronaGlowna();

        /*String warning = JakPracujemy.isBlogTechnicznyText();
        assertEquals(warning, "invalid");*/
    }
}