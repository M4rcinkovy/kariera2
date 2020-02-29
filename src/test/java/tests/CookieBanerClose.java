package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

public class CookieBanerClose extends TestBase{

    @Test
    public void asUserSwitchToAnotherPage() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage
                .clickOnOfertyPracy();

    }
}
