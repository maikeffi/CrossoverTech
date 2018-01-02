package com.maikeffi.crossover.interview.test.steps;




import com.maikeffi.crossover.interview.test.runner.CrossOverTest;
import com.maikeffi.crossover.review.auto.page.HomePage;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CrossOverSteps implements En {
    private HomePage homePage;
    public CrossOverSteps() {
        Given("^I open (\\S+) browser$",(String browser) ->{
            WebDriver driver = CrossOverTest.manager.getDriverForBrowser(browser);
            homePage = new HomePage(driver,"baseUrl");
        });

        When("^I enter Url for CrossOver in the browser$", () -> {
            // Write code here that turns the phrase above into concrete actions
            homePage.visitPage();
        });

        Then("^CrossOver Home Should Open$", () -> {
            assertEquals("Title of page","Crossover", homePage.getPageTitle());
        });
    }
}
