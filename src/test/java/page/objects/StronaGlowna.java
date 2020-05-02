package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.util.ArrayList;
import java.util.List;

import static generic.assertions.AssertWebElement.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class StronaGlowna{

    private Logger logger = LogManager.getLogger(StronaGlowna.class);

    @FindBy(className = "o-Button--Small")
    private WebElement cookieButton;

    @FindBy(className = "s-HeroBanner__Video")
    private WebElement videoMenuField;

    @FindBy(id = "menu-item-604")
    private WebElement ofertyPracyMenuField;

    @FindBy(className = "s-Form__Name")
    private WebElement nameField;

    @FindBy(className = "s-Form__Surname")
    private WebElement surnameField;

    @FindBy(className = "s-Form__Email")
    private WebElement emailField;

    @FindBy(className = "s-Form__Technologies")
    private WebElement technologiesField;

    @FindBy(className = "s-Form__Experience")
    private WebElement experienceField;

    @FindBy(className = "s-Form__CheckboxLabel")
    private WebElement checkboxLabel;

    @FindBy(className = "o-Button--Submit")
    private WebElement submitButton;
//o-Button o-Button--Submit -> tak nie piszemy bo to jest klasa w klasie

    @FindBy(className = "o-Newsletter__Response--InvalidEmail")
    private WebElement invalidResponse;

    @FindBy(className = "o-Newsletter__Response")
    private WebElement successResponse;

    @FindBy(className = "o-Newsletter__Response--AlreadySubscribed")
    private WebElement alreadySubscrivedError;

    @FindBy(className = "s-Form__Meeting")
    private WebElement isFormActive;

    @FindBy(xpath = "//img[contains(@alt, 'image_one')]")
    private WebElement pictureBreakfastFormOne;

    @FindBy(xpath = "//img[contains(@alt, 'image_two')]")
    private WebElement pictureBreakfastFormTwo;

    public StronaGlowna() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Czy video jest wyswietlane na stronie")
    public StronaGlowna videoFieldIs() {
        WaitForElement.waitUntilElementIsVisible(videoMenuField);
        assertThat(videoMenuField).isDisplayed();
        return this;
    }

    @Step("Czy na stronie sa pokazywane cookiesy")
    public StronaGlowna isCookieShow() {
        WaitForElement.waitUntilElementIsVisible(cookieButton);
        assertThat(cookieButton).isDisplayed();
        return this;
    }

    @Step("Czy przycisk 'zaakceptuj' poprawnie sie klika i Cookies'y znikaja")
    public StronaGlowna clickOnCookieButtonPopUp() {
        WaitForElement.waitUntilElementIsVisible(cookieButton);
        cookieButton.click();
        logger.info("Clicked on Cookie button, named: 'Akceptuje'");
        return this;
    }

    public StronaGlowna isFormIsActive() {
        WaitForElement.waitUntilElementIsVisible(isFormActive);
        assertThat(isFormActive).isDisplayed();
        return this;
    }

    public StronaGlowna isImageOneVisible(){
        WaitForElement.waitUntilElementIsVisible(pictureBreakfastFormOne);
        assertThat(pictureBreakfastFormOne).isDisplayed();
        return this;
    }

    public StronaGlowna isImageTwoVisible(){
        WaitForElement.waitUntilElementIsVisible(pictureBreakfastFormTwo);
        assertThat(pictureBreakfastFormTwo).isDisplayed();
        return this;
    }

    public StronaGlowna typeIntoNameField (String nameBreakfast) {
        WaitForElement.waitUntilElementIsVisible(nameField);
        nameField.sendKeys(nameBreakfast);
        logger.info("Typed into 'Name' Field {}", nameBreakfast);
        return this;
    }

    public StronaGlowna typeIntoSurnameField (String surnameBreakfast) {
        WaitForElement.waitUntilElementIsVisible(surnameField);
        surnameField.sendKeys(surnameBreakfast);
        logger.info("Typed into 'Surname' Field {}", surnameBreakfast);
        return this;
    }

    public StronaGlowna typeIntoEmailField (String emailBreakfast) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(emailBreakfast);
        logger.info("Typed into 'e-mail' Field {}", emailBreakfast);
        return this;
    }

    public StronaGlowna typeIntoTechnologyField (String technologyBreakfast) {
        WaitForElement.waitUntilElementIsVisible(technologiesField);
        technologiesField.sendKeys(technologyBreakfast);
        logger.info("Typed into 'Technologies' Field {}", technologyBreakfast);
        return this;
    }

    public StronaGlowna zczytanieListingTest() {
        Select writeFormDropDown = new Select(experienceField);
            List<WebElement> options = writeFormDropDown.getOptions();
            List<String> namesOfOptions = new ArrayList<String>();
            for (WebElement option : options) {
                namesOfOptions.add(option.getText());
                System.out.println(option.getText());
            }
            List<String> expectedNamesOfOptions = new ArrayList<String>();
                expectedNamesOfOptions.add("Wybierz jakie masz doświadczenie");
                expectedNamesOfOptions.add("Nie mam doświadczenia");
                expectedNamesOfOptions.add("< 1 rok");
                expectedNamesOfOptions.add("2 - 5 lat");
                expectedNamesOfOptions.add("> 5 lat");

        assertEquals(namesOfOptions, expectedNamesOfOptions);

        return this;
    }

    public StronaGlowna dropDownListingTest() {

        Select formDropDown = new Select(experienceField);

        WaitForElement.waitUntilElementIsVisible(experienceField);
        formDropDown.selectByValue("Nie mam doświadczenia");
        assertEquals(formDropDown.getFirstSelectedOption().getText(),"Nie mam doświadczenia");
        logger.info("Choose 'Nie mam doświadczenia'", formDropDown);

        formDropDown.selectByValue("< 1 rok");
        assertEquals(formDropDown.getFirstSelectedOption().getText(),"< 1 rok");
        logger.info("Choose '< 1 rok'", formDropDown);

        formDropDown.selectByValue("2 - 5 lat");
        assertEquals(formDropDown.getFirstSelectedOption().getText(),"2 - 5 lat");
        logger.info("Choose '2 - 5 lat'", formDropDown);

        formDropDown.selectByValue("> 5 lat");
        assertEquals(formDropDown.getFirstSelectedOption().getText(),"> 5 lat");
        logger.info("Choose '> 5 lat", formDropDown);

        return this;
    }

    public StronaGlowna clickOnCheckboxLabelField() {
        WaitForElement.waitUntilElementIsVisible(checkboxLabel);
        checkboxLabel.click();
        logger.info("Clicked on 'checkbox' Label");
        return this;
    }

    public StronaGlowna clickOnSignUpButton() {
        WaitForElement.waitUntilElementIsVisible(submitButton);
        submitButton.click();
        logger.info("Clicked on Submit Button");
        return this;
    }

    public StronaGlowna getInvalidFormMessage(String errorHasText) {
        logger.info("CHECKING IF warning message {} is displayed", errorHasText);
        WaitForElement.waitUntilElementIsVisible(invalidResponse);
        AssertWebElement.assertThat(invalidResponse).isDisplayed().hasText(errorHasText);
        return this;
    }

    public StronaGlowna getPositiveFormMessage(String correctHasText) {
        logger.info("CHECKING if correct message {} is displayed", correctHasText);
        WaitForElement.waitUntilElementIsVisible(successResponse);
        AssertWebElement.assertThat(successResponse).isDisplayed().hasText(correctHasText);
        return this;
    }

    public StronaGlowna getSameMailFormMessage(String doubleMailHasText) {
        logger.info("CHECKING IF same mail try to send twice:{} ", doubleMailHasText);
        WaitForElement.waitUntilElementIsVisible(alreadySubscrivedError);
        AssertWebElement.assertThat(alreadySubscrivedError).isDisplayed().hasText(doubleMailHasText);
        return this;
    }

    public OfertyPracy clickOnOfertyPracy() {
        WaitForElement.waitUntilElementIsClickable(ofertyPracyMenuField);
        ofertyPracyMenuField.click();
        logger.info("Clicked on 'Oferty Pracy' Navigation Menu");
        return new OfertyPracy();
    }
}

       /* Actions action = new Actions((WebDriver) submitButton);
        Action seriesOfAction = action
                .moveToElement(submitButton)
                .click()
                .build();

        seriesOfAction.perform();

        //action.moveToElement(submitButton).click().build().perform();*/

       /* JavascriptExecutor jse2 = (JavascriptExecutor) qualityExcitesLogoFooter;
        jse2.executeScript("qualityExcitesLogoFooter.click()", qualityExcitesLogoFooter);
        */

        /* poprzednia asercja
            public boolean isImageTwoVisible(){
               WaitForElement.waitUntilElementIsVisible(pictureBreakfastFormTwo);
                boolean isImageCiapakVisibleTwo = pictureBreakfastFormTwo.isDisplayed();
                logger.info("CZY ZDJECIE Drugie z formularza sniadaniowego SIE WYSWIETLA: {}", isImageCiapakVisibleTwo);
            return isImageCiapakVisibleTwo;
    }
         */

/*
    /*public String getInvalidFormMessage() {
        WaitForElement.waitUntilElementIsVisible(invalidResponse);
        String warning = invalidResponse.getText();
        logger.info("Returned warning message was:{}", warning);
        return warning;
    }
 */