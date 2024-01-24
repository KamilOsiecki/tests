package com.gitlab.rmarzec.framework.pages.youtube;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class YoutubeVideoGridPage extends BasePage {
    public YoutubeVideoGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#contents #contents .ytd-rich-grid-row")
    private List<WebElement> videoMiniatures;

    public List<YoutubeVideoMiniaturePage> getVideos() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#contents #contents .ytd-rich-grid-row"))));
        List<YoutubeVideoMiniaturePage> youtubeVideoMiniaturePages = new ArrayList<>();

        for (WebElement element : videoMiniatures) {
            youtubeVideoMiniaturePages.add(new YoutubeVideoMiniaturePage(driver, element));
        }
        return youtubeVideoMiniaturePages;
    }

    public void getNoLiveStreamVideoDetails(int numberOfVideos) {
        List<YoutubeVideoMiniaturePage> videos = getVideos();

        for (int i = 0; i < numberOfVideos; i++) {

            if (!videos.get(i).isLiveStream()) {
                System.out.println("Video title: " + videos.get(i).getTitle() + "\n" + " || Video length: " + videos.get(i).getLength() + "\n");
            } else {
                System.out.println("No description for live stream videos\n");
            }

            actions.scrollByAmount(0, 350).build().perform();
        }
    }
}