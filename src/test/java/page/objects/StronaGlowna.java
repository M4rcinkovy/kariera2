package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static generic.assertions.AssertWebElement.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class StronaGlowna extends BasePage {

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
    private WebElement alreadySubscribedError;

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
    public StronaGlowna assertIsVideoPlayerShow() {
        WaitForElement.waitUntilElementIsVisible(videoMenuField);
        assertThat(videoMenuField).isDisplayed();
        return this;
    }

    File scrFile = ((TakesScreenshot) videoMenuField).getScreenshotAs(OutputType.FILE);
    {
        try {
            FileUtils.copyFile(scrFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Step("Czy na stronie sa pokazywane cookiesy")
    public StronaGlowna assertIsCookieBarShow() {
        WaitForElement.waitUntilElementIsVisible(cookieButton);
        assertThat(cookieButton).isDisplayed();
        return this;
    }

    @Step("Czy przycisk 'zaakceptuj' poprawnie sie klika i Cookies'y znikaja")
    public StronaGlowna clickOnCookieButtonPopUp() {
        WaitForElement.waitUntilElementIsVisible(cookieButton);
        cookieButton.click();
        log().info("Clicked on Cookie button, named: 'Akceptuje'");
        return this;
    }

    @Step("Czy formularz poprawnie sie wyswietla")
    public StronaGlowna assertIsFormIsActive() {
        WaitForElement.waitUntilElementIsVisible(isFormActive);
        assertThat(isFormActive).isDisplayed();
        return this;
    }

    @Step("Czy zdjecie pierwsze jest wyswietlane")
    public StronaGlowna assertIsImageOneVisible() {
        WaitForElement.waitUntilElementIsVisible(pictureBreakfastFormOne);
        assertThat(pictureBreakfastFormOne).isDisplayed();
        return this;
    }

    @Step("Czy zdjecie drugie jest wyswietlane")
    public StronaGlowna assertIsImageTwoVisible() {
        WaitForElement.waitUntilElementIsVisible(pictureBreakfastFormTwo);
        assertThat(pictureBreakfastFormTwo).isDisplayed();
        return this;
    }

    @Step("Czy pole 'imie' jest wypelnione: {nameBreakfast}")
    public StronaGlowna typeIntoNameField(String nameBreakfast) {
        WaitForElement.waitUntilElementIsVisible(nameField);
        nameField.sendKeys(nameBreakfast);
        log().info("Typed into 'Name' Field {}", nameBreakfast);
        return this;
    }

    @Step("Czy pole 'nazwisko' jest wypelnione: {surnameBreakfast}")
    public StronaGlowna typeIntoSurnameField(String surnameBreakfast) {
        WaitForElement.waitUntilElementIsVisible(surnameField);
        surnameField.sendKeys(surnameBreakfast);
        log().info("Typed into 'Surname' Field {}", surnameBreakfast);
        return this;
    }

    @Step("Wpisany e-mail w tescie przez użytkownika to: {emailBreakfast}")
    public StronaGlowna typeIntoEmailField(String emailBreakfast) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(emailBreakfast);
        log().info("Typed into 'e-mail' Field {}", emailBreakfast);
        return this;
    }

    @Step("Jakie technologie zostały wypełnione: {technologyBreakfast}")
    public StronaGlowna typeIntoTechnologyField(String technologyBreakfast) {
        WaitForElement.waitUntilElementIsVisible(technologiesField);
        technologiesField.sendKeys(technologyBreakfast);
        log().info("Typed into 'Technologies' Field {}", technologyBreakfast);
        return this;
    }

    @Step("Zczytanie listy czy wszystko sie zgadza")
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

    @Step("Wybor opcji z listy rozwijanej")
    public StronaGlowna dropDownListingTest() {

        Select formDropDown = new Select(experienceField);
        WaitForElement.waitUntilElementIsVisible(experienceField);

        formDropDown.selectByValue("Nie mam doświadczenia");
        assertEquals(formDropDown.getFirstSelectedOption().getText(), "Nie mam doświadczenia");
        log().info("Choose 'Nie mam doświadczenia'");

        formDropDown.selectByValue("< 1 rok");
        assertEquals(formDropDown.getFirstSelectedOption().getText(), "< 1 rok");
        log().info("Choose '< 1 rok'");

        formDropDown.selectByValue("2 - 5 lat");
        assertEquals(formDropDown.getFirstSelectedOption().getText(), "2 - 5 lat");
        log().info("Choose '2 - 5 lat'");

        formDropDown.selectByValue("> 5 lat");
        assertEquals(formDropDown.getFirstSelectedOption().getText(), "> 5 lat");
        log().info("Choose '> 5 lat");

        return this;
    }

    @Step("Czy pole z checkboxem akceptujacym zgode jest poprawnie zaznaczony")
    public StronaGlowna clickOnCheckboxLabelField() {
        WaitForElement.waitUntilElementIsVisible(checkboxLabel);
        checkboxLabel.click();
        log().info("Clicked on 'checkbox' Label");
        return this;
    }

    @Step("Czy przycisk wyslij dziala poprawnie")
    public StronaGlowna clickOnSignUpButton() {
        WaitForElement.waitUntilElementIsVisible(submitButton);
        submitButton.click();
        log().info("Clicked on Submit Button");
        return this;
    }

    @Step("Czy error z wiadomoscia sie wyswietla {errorHasText}")
    public StronaGlowna getInvalidFormMessage(String errorHasText) {
        log().info("CHECKING IF warning message {} is displayed", errorHasText);
        WaitForElement.waitUntilElementIsVisible(invalidResponse);
        AssertWebElement.assertThat(invalidResponse).isDisplayed().hasText(errorHasText);
        return this;
    }

    @Step("Czy wyslanie prawidlowo maila wyswietla prawidlowa wiadomosc: {correctHasText}")
    public StronaGlowna getPositiveFormMessage(String correctHasText) {
        log().info("CHECKING if correct message {} is displayed", correctHasText);
        WaitForElement.waitUntilElementIsVisible(successResponse);
        AssertWebElement.assertThat(successResponse).isDisplayed().hasText(correctHasText);
        return this;
    }

    @Step("Jaki leci komunikat gdy chce sie zapisac 2-razy ten sam mail {doubleMailHasText}")
    public StronaGlowna getSameMailFormMessage(String doubleMailHasText) {
        log().info("CHECKING IF same mail try to send twice:{} ", doubleMailHasText);
        WaitForElement.waitUntilElementIsVisible(alreadySubscribedError);
        AssertWebElement.assertThat(alreadySubscribedError).isDisplayed().hasText(doubleMailHasText);
        return this;
    }

    @Step("Po wyslaniu/niewyslaniu wiadomosci, przechodzimy na podstrone z ofertami pracy")
    public OfertyPracy clickOnOfertyPracy() {
        WaitForElement.waitUntilElementIsClickable(ofertyPracyMenuField);
        ofertyPracyMenuField.click();
        log().info("Clicked on 'Oferty Pracy' Navigation Menu");
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