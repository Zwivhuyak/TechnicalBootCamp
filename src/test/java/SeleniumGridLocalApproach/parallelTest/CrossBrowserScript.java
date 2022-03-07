package SeleniumGridLocalApproach.parallelTest;

import org.openqa.selenium.By;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {

    RemoteWebDriver driver;

    /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("safari")){
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setPlatform(Platform.WINDOWS);
            dc.setBrowserName("safari");
            

            driver = new RemoteWebDriver(new URL("http://192.168.8.191:4444"),dc);

        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setPlatform(Platform.WINDOWS);
            dc.setBrowserName("chrome");

            driver = new RemoteWebDriver(new URL("http://192.168.8.191:4444"),dc);
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){

        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void goToGoogle() throws InterruptedException{
        driver.get("http://google.com");




    }
}


