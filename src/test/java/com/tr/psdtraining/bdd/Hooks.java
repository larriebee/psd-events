package com.tr.psdtraining.bdd;

import com.tr.psdtraining.bdd.support.WebConnector;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import java.util.concurrent.TimeUnit;

public class Hooks extends WebConnector {

    /**
     * Runs before each scenario to delete HAR files from the previous test run and maximizes the browser window
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Executing scenario: " + scenario.getName());
        scenarioName = scenario.getName();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (!scenario.getStatus().equals("passed")) {
            embedScreenshot(scenario);
        }
    }

    /**
     * Takes a screenshot of the browser in it's current state and adds it to the Scenario object
     *
     * @param scenario The scenario object is required to embed the screenshot to
     */
    private void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }
}
