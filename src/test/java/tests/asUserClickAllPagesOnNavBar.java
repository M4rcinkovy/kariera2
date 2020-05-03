package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class asUserClickAllPagesOnNavBar extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test switch between sites")
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