package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.StronaGlowna;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class PositiveAndTwiceFillBreakfastForm extends TestBase {

    @TmsLink("ID-3")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is to log in using proper data" +
            " and check if proper info and warning message are displayed")
    public void asUserTryToFillFormWithIncorrectPersonalData() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        StronaGlowna stronaGlowna = new StronaGlowna();
        stronaGlowna
                .assertIsVideoPlayerShow()
                .assertIsCookieBarShow()
                .clickOnCookieButtonPopUp()
                .assertIsFormIsActive()
                .assertIsImageOneVisible()
                .assertIsImageTwoVisible()
                .typeIntoNameField("Mar")
                .typeIntoSurnameField("Cin")
                .typeIntoEmailField("mmolenda@future-processing.com")
                .typeIntoTechnologyField("Selenium, Java, Wordpress, HTML, CSS")
                .zczytanieListingTest()
                .dropDownListingTest()
                .clickOnCheckboxLabelField()
                .clickOnSignUpButton()
                .getPositiveFormMessage("Twoje zgłoszenie zostało zapisane. Dziękujemy!")
                .clickOnSignUpButton()
                .getSameMailFormMessage("Gdyby tylko się dało zapisać twój mail dwa razy :D");
    }
}
