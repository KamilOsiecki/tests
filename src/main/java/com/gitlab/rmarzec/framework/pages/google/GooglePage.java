package com.gitlab.rmarzec.framework.pages.google;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#L2AGLb")
    private WebElement acceptCookiesBtn;
    @FindBy(css = "#APjFqb")
    private WebElement searchInput;

    @FindBy(css = ".FPdoLc [name='btnI']")
    private WebElement feelingLuckyBtn;

    @FindBy(css = ".lnXdpd")
    private WebElement googleImage;

    public GooglePage acceptCookies() {
        click(acceptCookiesBtn);
        return this;
    }

    public GooglePage typeSearchValue(String value) {
        searchInput.sendKeys(value);
        return this;
    }

    public GooglePage clickFeelingLuckyBtn() {
        click(googleImage);
        click(feelingLuckyBtn);
        return this;
    }
}