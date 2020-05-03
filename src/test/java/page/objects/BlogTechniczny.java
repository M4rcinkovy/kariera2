package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class BlogTechniczny{

    private Logger logger = LogManager.getLogger(BlogTechniczny.class);

    @FindBy(id = "menu-item-11995")
    private WebElement faqField;

    public BlogTechniczny() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public FAQ clickOnFAQ() {
        WaitForElement.waitUntilElementIsClickable(faqField);
            String isTextIsProperInNavBar = faqField.getText();
            logger.info("Zwrócono text z navbara: {}", isTextIsProperInNavBar);
            assertEquals(isTextIsProperInNavBar, "FAQ");
        faqField.click();
        logger.info("Clicked on 'FAQ' Navigation Menu");
        return new FAQ();
    }

}