package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getLogger(TopMenuPage.class);

    @FindBy(id = "menu-item-604")
    private WebElement ofertyPracyMenuField;

    @FindBy(id = "menu-item-11993")
    private WebElement oNasField;

    @FindBy(id = "menu-item-11994")
    private WebElement jakPracujemyField;

    @FindBy(id = "menu-item-12094")
    private WebElement blogTechnicznyFiekd;

    @FindBy(id = "menu-item-11995")
    private WebElement faqField;

    @FindBy(id = "menu-item-605")
    private WebElement kontaktField;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public OfertyPracy clickOnNavBoxes() {
        WaitForElement.waitUntilElementIsClickable(ofertyPracyMenuField);
        ofertyPracyMenuField.click();
        logger.info("Clicked on Login Button");
        return new OfertyPracy();
    }

}
