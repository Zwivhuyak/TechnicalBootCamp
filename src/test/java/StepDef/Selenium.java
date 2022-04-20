package StepDef;

import bsh.Capabilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Selenium {
    RemoteWebDriver driver;

    @Given("^that you have the configuration of the following environment : (.+)$")
    public void that_you_have_the_configuration_of_the_following_environment_(String environment) throws Throwable {
        switch (environment){
            case "local":

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.facebook.com/");

            case "grid":

                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setPlatform(Platform.LINUX);
                dc.setBrowserName("chrome");

                driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444"), dc);
                driver.get("https://www.facebook.com/");
                System.out.println(driver.getCapabilities());



        }

    }

    @When("^you chose the following browser : (.+)$")
    public void you_chose_the_following_browser_(String browser) throws Throwable {

    }

    @Then("^assert the web title (.+)$")
    public void assert_the_web_title(String expectedtitle) throws Throwable {
        Thread.sleep(5000);

        Assert.assertEquals(expectedtitle,driver.getTitle());

    }

    @And("^when you navigate to the following url : (.+)$")
    public void when_you_navigate_to_the_following_url_(String url) throws Throwable {
        driver.get(url);

    }

}
