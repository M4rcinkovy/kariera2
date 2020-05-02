package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.*;

public class FailedFillBreakfastForm extends TestBase {

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
                .typeIntoNameField("User Selenium")
                .typeIntoSurnameField("Test")
                .typeIntoEmailField("asd@a")
                .typeIntoTechnologyField("Java, C#")
                .zczytanieListingTest()
                .dropDownListingTest()
                .clickOnCheckboxLabelField()
                .clickOnSignUpButton();

        stronaGlowna
                .getInvalidFormMessage("Niepoprawny mail. Spróbuj jeszcze raz.");

    }
}

//asercja na pojawienie sie napisu obok zdjecia ciapaka ALBO niepoprawne uzu;enienie formularza
// stopka - czy boolean isdisplayed i enabled czy sa przyciski w stopce - numer telefonu i mapka

/*
        StronaGlowna stronaGlowna = new StronaGlowna();
        assertTrue(stronaGlowna.isFormIsActive());
        assertTrue(stronaGlowna.isImageOneVisible());
        assertTrue(stronaGlowna.isImageTwoVisible());
 */

               /* String warningMessage = stronaGlowna.getInvalidFormMessage();
                assertEquals(warningMessage, "Niepoprawny mail. Spróbuj jeszcze raz.");*/