package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class JakPracujemy extends BasePage{

    @FindBy(id = "menu-item-12094")
    private WebElement blogTechnicznyFiekd;

    public JakPracujemy() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public BlogTechniczny clickOnBlogTechniczny() {
        WaitForElement.waitUntilElementIsClickable(blogTechnicznyFiekd);
            String isTextIsProperInNavBar = blogTechnicznyFiekd.getText();
            log().info("Zwrócono text z navbara: {}", isTextIsProperInNavBar);
            assertEquals(isTextIsProperInNavBar, "BLOG");
        blogTechnicznyFiekd.click();
        log().info("Clicked on 'Blog techniczny' Navigation Menu");
        return new BlogTechniczny();
    }

    /*public String isBlogTechnicznyText() {
        WaitForElement.waitUntilElementIsClickable(blogTechnicznyFiekd);
        String napis1 = blogTechnicznyFiekd.getText();
        logger.info("Returned, was: {}", napis1);
        return napis1;
    //cos nie dziala - nie potrafi zczytac tej metody
    }*/

}