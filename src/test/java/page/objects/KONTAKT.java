package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class KONTAKT extends BasePage{

    @FindBy(className = "o-Logo__Mark")
    private WebElement stronaGlownaField;

    public KONTAKT() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public StronaGlowna clickOnStronaGlowna() {
        WaitForElement.waitUntilElementIsClickable(stronaGlownaField);
            boolean isLogoisActive = stronaGlownaField.isDisplayed();
            log().info("CZY klikniecie w logo na strone glowna przenosi użytkownika na HomePage: {}", isLogoisActive);
        stronaGlownaField.click();
        log().info("Clicked on Logo = Strona glowna");
        return new StronaGlowna();
    }
}