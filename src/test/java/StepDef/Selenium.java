package StepDef;

import bsh.Capabilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("use-fake-device-for-media-stream");
                options.addArguments("use-fake-ui-for-media-stream");
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver");
                ///System.setProperty("webdriver.chrome.driver", "src/main/resources/ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();

            case "grid":

                driver = new RemoteWebDriver(new URL("http://172.19.0.2:4444"), DesiredCapabilities.chrome());

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
