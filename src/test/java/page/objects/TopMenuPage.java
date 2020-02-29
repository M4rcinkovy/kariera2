package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

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

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnOfertyPracy() {
        ofertyPracyMenuField.click();
        oNasField.click();
        jakPracujemyField.click();
        blogTechnicznyFiekd.click();
        faqField.click();
        kontaktField.click();
    }

}
