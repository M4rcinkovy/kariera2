package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    @Step("Loading configuration from configuration.properties")
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser to: {browserType} and navigating to Home Page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

// FOOTERA zautomatyzowac - i formularz kotaktowy na naszej stornie glowne j
// jak bede testowal CF7 - wykorzystac zmienna z Applications URLS