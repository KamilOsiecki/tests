package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.base.TestBase;
import com.gitlab.rmarzec.framework.pages.youtube.YoutubePage;
import com.gitlab.rmarzec.framework.pages.youtube.YoutubeVideoGridPage;
import com.gitlab.rmarzec.framework.pages.youtube.YoutubeVideoMiniaturePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.gitlab.rmarzec.framework.providers.UrlProvider.YOUTUBE;

public class Task4Test extends TestBase {

    @BeforeMethod
    public void navigateToWiki() {
        driver.get(YOUTUBE);
    }

    @Test
    public void Task4Test() {

        at(YoutubePage.class)
                .acceptCookies();

        List<YoutubeVideoMiniaturePage> videos = at(YoutubeVideoGridPage.class)
                .getVideos();

        at(YoutubeVideoGridPage.class)
                .getNoLiveStreamVideoDetails(12);
    }
}