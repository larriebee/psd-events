package com.tr.psdtraining.bdd;


import com.tr.psdtraining.bdd.support.WebConnector;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", strict = true, format = {"html:target/cucumber"})

public class CucumberChromeRunner {
    @BeforeClass
    public static void setUp() {
        WebConnector.getInstance().initialiseDriver(WebConnector.Browsers.valueOf("Chrome"));
    }

    @AfterClass
    public static void tearDown() {
        WebConnector.driver.quit();
    }
}