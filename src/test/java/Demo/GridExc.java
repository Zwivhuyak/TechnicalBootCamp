package Demo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridExc {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setPlatform(Platform.MAC);
        dc.setBrowserName("firefox");


        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.8.223:4444"),dc);

        driver.get("https://google.com");

        Thread.sleep(10000);



    }
}
