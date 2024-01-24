package com.gitlab.rmarzec.base;

import com.gitlab.rmarzec.framework.enums.Browsers;
import com.gitlab.rmarzec.framework.pages.base.BasePage;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

@Slf4j
public class TestBase {
    protected static WebDriver driver;
    private static DriverFactory driverFactory;

    @BeforeMethod
    public void setupDriver() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(Browsers.CHROME);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        try {
            driver.quit();
            log.info("WebDriver closed successfully");
        } catch (Exception e) {
            log.error("WebDriver was not closed.");
        }
    }

    @SneakyThrows
    public <T extends BasePage> T at(Class<T> pageType) {
        log.info(pageType.getSimpleName() + " was initialized");
        return pageType.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }

    public static void zoomOut(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom='75%';");
    }
}