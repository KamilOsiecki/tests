package com.gitlab.rmarzec.framework.pages.w3schools;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class W3SchoolsPage extends BasePage {
    public W3SchoolsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#accept-choices")
    private WebElement acceptCookiesBtn;

    @FindBy(css = "#main >div:nth-child(5) > a")
    private WebElement tryItYourselfBtn;

    public W3SchoolsPage verifyPagePresence() {
        String expectedURL = "https://www.w3schools.com/tags/tag_select.asp";
        String actualURL = driver.getCurrentUrl();

        if (!actualURL.equals(expectedURL)) {
            System.out.println("Actual URL address is incorrect. Navigating to the proper site: " + expectedURL);
            driver.get(expectedURL);
        }
        return this;
    }

    public W3SchoolsPage acceptCookies() {
        click(acceptCookiesBtn);
        return this;
    }

    public W3SchoolsPage clickTryItYourself() {
        click(tryItYourselfBtn);
        return this;
    }
}