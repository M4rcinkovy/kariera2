package driver.manager;

import io.qameta.allure.Step;

public class DriverUtils {

    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigating to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }

    //@Step("Back page to URL: {pageUrl}")
    public static void backToPage() {
        DriverManager.getWebDriver().navigate().back();
    }

    /*@Step("Navigating to URL: {pageUrl}")
    public static void forwardToPage() {
        DriverManager.getWebDriver().navigate().forward();
    }

    @Step("Close tab")
    public static void closeTab() {
        DriverManager.getWebDriver().close();
    }

    @Step("Navigating to URL: {pageUrl}")
    public static void cokolwiek() {
      //  DriverManager.executeScript("window.history.go(-1)");
    }*/
}
