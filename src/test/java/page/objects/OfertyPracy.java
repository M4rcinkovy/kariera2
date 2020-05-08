package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class OfertyPracy extends BasePage{

    private Logger logger = LogManager.getLogger(OfertyPracy.class);

    @FindBy(id = "menu-item-11993")
    private WebElement oNasField;

    public OfertyPracy() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ONas clickOnONas() {
        WaitForElement.waitUntilElementIsClickable(oNasField);
            String isTextIsProperInNavBar = oNasField.getText();
            log().info("Zwrócono text z navbara: {}", isTextIsProperInNavBar);
            assertEquals(isTextIsProperInNavBar, "O NAS");
        oNasField.click();
        log().info("Clicked on 'ONas' Navigation Menu");
        return new ONas();
    }

}