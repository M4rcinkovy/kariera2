package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class FAQ extends BasePage{

    @FindBy(id = "menu-item-605")
    private WebElement kontaktField;

    public FAQ() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public KONTAKT clickOnKONTAKT() {
        WaitForElement.waitUntilElementIsClickable(kontaktField);
        String isTextIsProperInNavBar = kontaktField.getText();
        log().info("Zwrócono text z navbara: {}", isTextIsProperInNavBar);
        assertEquals(isTextIsProperInNavBar, "KONTAKT");
        kontaktField.click();
        log().info("Clicked on 'KONTAKT' Navigation Menu");
        return new KONTAKT();
    }

}