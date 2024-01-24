package com.gitlab.rmarzec.framework.pages.youtube;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubeVideoMiniaturePage extends BasePage {

    public YoutubeVideoMiniaturePage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = "#video-title")
    private WebElement title;
    @FindBy(css = "#channel-name #text>a")
    private WebElement channelName;
    @FindBy(css = "span#text")
    private WebElement length;

    @FindBy(css = "div[class~='badge-style-type-live-now-alternate']>p")
    private WebElement isLive;

    @FindBy(css = "span.ytd-thumbnail-overlay-time-status-renderer")
    private WebElement duration;

    public String getTitle() {
        waitForElementToBeVisible(title);
        return title.getText();
    }

    public String getChannelName() {
        waitForElementToBeVisible(channelName);
        return channelName.getText();
    }

    public String getLength() {
        waitForElementToBeVisible(length);
        return length.getText();
    }

    public boolean isLiveStream() {
        try {
            return isLive.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}