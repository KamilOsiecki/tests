package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.base.TestBase;
import com.gitlab.rmarzec.framework.pages.google.GooglePage;
import com.gitlab.rmarzec.framework.pages.w3schools.W3SchoolsEditorPage;
import com.gitlab.rmarzec.framework.pages.w3schools.W3SchoolsPage;
import org.testng.annotations.*;

import static com.gitlab.rmarzec.framework.enums.Cars.*;
import static com.gitlab.rmarzec.framework.providers.UrlProvider.GOOGLE;

public class Task3Test extends TestBase {

    @BeforeMethod
    public void navigateToWiki() {
        driver.get(GOOGLE);
    }

    @Test
    public void Task2Test() {
        at(GooglePage.class)
                .acceptCookies()
                .typeSearchValue("HTML select tag - W3Schools")
                .clickFeelingLuckyBtn();

        at(W3SchoolsPage.class)
                .verifyPagePresence()
                .acceptCookies()
                .clickTryItYourself();

        at(W3SchoolsEditorPage.class)
                .switchToTheResultWindow()
                .getResultHeader()
                .selectCar(VOLVO)
                .getSelectedCarDetails();
    }
}