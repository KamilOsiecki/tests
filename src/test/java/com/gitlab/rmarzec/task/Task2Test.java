package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.base.TestBase;
import com.gitlab.rmarzec.framework.pages.wikipedia.WikipediaPage;
import org.testng.annotations.*;

import static com.gitlab.rmarzec.framework.providers.UrlProvider.WIKIPEDIA;

public class Task2Test extends TestBase {
    @BeforeMethod
    public void navigateToWiki() {
        driver.get(WIKIPEDIA);
    }

    @Test(testName = "Task1Test1")
    public void Task1Test1() {
        at(WikipediaPage.class)
                .expandLanguagesDropdown()
                .displayLanguagesName();
    }

    @Test(testName = "Task1Test2")
    public void Task1Test2() {
        at(WikipediaPage.class)
                .expandLanguagesDropdown()
                .ternaryOperation();
    }
}