package com.maikeffi.crossover.interview.test.runner;

import com.maikeffi.crossover.review.auto.core.Manager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        format = {"pretty", "html:target/reports/cucumber/html", "json:target/reports/cucumber/all_tests.json", "junit:target/reports/junit/all_tests.xml"},
        glue = {"com.maikeffi.crossover.interview.test.steps"},
        tags = {"@JobSearch"})
public class CrossOverTest {
    public static Manager manager = new Manager();

    @BeforeClass
    public static void setUp(){
        String browser = manager.getProperty("webBrowser");

        if (browser.equals("chrome")) {
            setChromeDriverPath();
        }
    }

    private static void setChromeDriverPath() {
        if (SystemUtils.IS_OS_MAC_OSX) {
            setDriverPath("webdriver.chrome.driver","chromeDriverPathMac");
        } else if (SystemUtils.IS_OS_LINUX) {
            setDriverPath("webdriver.chrome.driver","chromeDriverPathLinux");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            setDriverPath("webdriver.chrome.driver","chromeDriverPathWindows");
        }
    }

    private static String setDriverPath(String basePropertyName, String driverPathProperties) {
        String propertyValue = System.getProperty("user.dir") + manager.getProperty(driverPathProperties);
        System.setProperty(basePropertyName, propertyValue);
        return propertyValue;
    }

    @AfterClass
    public static void tearDown(){
        manager.quitBrowser();
    }
}
