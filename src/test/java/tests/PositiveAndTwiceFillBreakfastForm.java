package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveAndTwiceFillBreakfastForm extends TestBase {

    @Test
    public void asUserTryToFillFormWithIncorrectPersonalData() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .videoFieldIs()
                .isCookieShow()
                .clickOnCookieButtonPopUp()
                .isFormIsActive()
                .isImageOneVisible()
                .isImageTwoVisible()
                .typeIntoNameField("Mar")
                .typeIntoSurnameField("Cin")
                .typeIntoEmailField("mmolenda@future-processing.com")
                .typeIntoTechnologyField("Selenium, Java, Wordpress, HTML, CSS")
                .zczytanieListingTest()
                .dropDownListingTest()
                .clickOnCheckboxLabelField()
                .clickOnSignUpButton();

        String warningMessage = stronaGlowna.getPositiveFormMessage();
        assertEquals(warningMessage, "Twoje zgłoszenie zostało zapisane. Dziękujemy!");

        stronaGlowna.clickOnSignUpButton();

        String warningMessage1 = stronaGlowna.getSameMailFormMessage();
        assertEquals(warningMessage1, "Gdyby tylko się dało zapisać twój mail dwa razy :D");
    }
}
