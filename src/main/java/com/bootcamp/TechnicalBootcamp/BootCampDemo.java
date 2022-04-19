package com.bootcamp.TechnicalBootcamp;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BootCampDemo {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cd = new DesiredCapabilities();
        cd.setPlatform(Platform.MAC);
        cd.setBrowserName("chrome");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.8.169:4444/"),cd);
        driver.get("https://fb.com");
        System.out.println(driver.getTitle());

    }
}
