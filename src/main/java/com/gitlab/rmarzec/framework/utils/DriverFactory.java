package com.gitlab.rmarzec.framework.utils;

import com.gitlab.rmarzec.framework.enums.Browsers;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
public class DriverFactory {

    WebDriver driver;
    Browsers browser;

    public WebDriver getDriver(Browsers browser) {
        this.browser = browser;
        switch (browser) {
            case FIREFOX -> getFirefoxDriver();
            case CHROME -> getChromeDriver();
            case EDGE -> getEdgeDriver();
        }
        return this.driver;
    }

    private void getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        driver = new FirefoxDriver(firefoxOptions);
        getDriverInformation(Browsers.FIREFOX);
    }

    private void getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-images");

//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        getDriverInformation(Browsers.CHROME);
    }

    private void getEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        driver = new EdgeDriver(edgeOptions);
        getDriverInformation(Browsers.EDGE);
    }

    private void getDriverInformation(Browsers browser) {
        log.info(browser + " WebDriver was initialized");
    }
}