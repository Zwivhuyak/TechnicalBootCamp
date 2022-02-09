package StepDef;

import MobileImplementation.MailSac;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    @Test
    public void configureIOSDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilites =new DesiredCapabilities();
        capabilites.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilites.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        capabilites.setBrowserName(MobileBrowserType.CHROME);

        //IOS_XCUI_Test     Apple
        capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        capabilites.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        capabilites.setCapability("commandTimeouts", "12000"); //.app


        RemoteWebDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilites);

        driver.get("https://ui.uatwamly.co.za/candidate");

        Thread.sleep(5000);
        WebElement webElement = driver.findElement(By.xpath("//input[@id='input-email']"));
        webElement.sendKeys("ndnvdnvndvmvjdvnvmvnjfnvjjj");





    }

   @Test
    public void configureAndroidDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("CapabilityName", "zwivhuya");
        dc.setCapability("PlatformName", "Android");
        dc.setBrowserName("Chrome");
        RemoteWebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver.get("https://ui.uatwamly.co.za/candidate");

        Thread.sleep(5000);
        WebElement webElement = driver.findElement(By.xpath("//input[@id='input-email']"));
        webElement.sendKeys("zwivhuya@mailsac.com");
        webElement.sendKeys(Keys.TAB);
        webElement.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        WebElement web = driver.findElement(By.xpath("//div[@class='collapse show']/..//input"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.sendKeys(MailSac.getOTP("zwivhuya@mailsac.com"));





    }

    public static class Main {

        public static void main(String[] args) throws MalformedURLException, InterruptedException {
            DriverFactory f = new DriverFactory();
            f.configureIOSDriver();
        }
    }
}
