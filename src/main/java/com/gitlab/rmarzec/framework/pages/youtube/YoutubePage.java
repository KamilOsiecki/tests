package com.gitlab.rmarzec.framework.pages.youtube;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubePage extends BasePage {

    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[aria-label^='Zaakceptuj']")
    private WebElement acceptCookiesBtn;

    public YoutubePage acceptCookies() {
        click(acceptCookiesBtn);
        return this;
    }
}