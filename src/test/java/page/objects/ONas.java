package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class ONas{

    private Logger logger = LogManager.getLogger(ONas.class);

    @FindBy(id = "menu-item-11994")
    private WebElement jakPracujemyField;

    public ONas() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public JakPracujemy clickOnJakPracujemy() {
        WaitForElement.waitUntilElementIsClickable(jakPracujemyField);
            String isTextIsProperInNavBar = jakPracujemyField.getText();
            logger.info("Zwrócono text z navbara: {}", isTextIsProperInNavBar);
            assertEquals(isTextIsProperInNavBar, "JAK PRACUJEMY");
        jakPracujemyField.click();
        logger.info("Clicked on 'Jak Pracujemy' Navigation Menu");
        return new JakPracujemy();
    }

}