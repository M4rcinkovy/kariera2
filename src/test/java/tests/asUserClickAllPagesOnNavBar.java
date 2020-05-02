package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class asUserClickAllPagesOnNavBar extends TestBase {

    @Test
    public void asUserSwitchToAnotherPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .assertIsVideoPlayerShow()
                .assertIsCookieBarShow()
                .clickOnCookieButtonPopUp()
                .assertIsFormIsActive()
                .assertIsImageOneVisible()
                .assertIsImageTwoVisible()
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