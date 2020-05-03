package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class KONTAKT{

    private Logger logger = LogManager.getLogger(KONTAKT.class);

    @FindBy(className = "o-Logo__Mark")
    private WebElement stronaGlownaField;

    public KONTAKT() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public StronaGlowna clickOnStronaGlowna() {
        WaitForElement.waitUntilElementIsClickable(stronaGlownaField);
            boolean isLogoisActive = stronaGlownaField.isDisplayed();
            logger.info("CZY klikniecie w logo na strone glowna przenosi użytkownika na HomePage: {}", isLogoisActive);
        stronaGlownaField.click();
        logger.info("Clicked on Logo = Strona glowna");
        return new StronaGlowna();
    }
}