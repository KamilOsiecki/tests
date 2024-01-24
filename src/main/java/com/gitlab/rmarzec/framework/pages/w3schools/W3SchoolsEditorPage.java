package com.gitlab.rmarzec.framework.pages.w3schools;

import com.gitlab.rmarzec.framework.enums.Cars;
import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class W3SchoolsEditorPage extends BasePage {

    private String iframeResult = "iframeResult";

    public W3SchoolsEditorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframeResult")
    private WebElement resultFrame;

    @FindBy(css = "body>h1")
    private WebElement resultHeader;

    @FindBy(css = "#cars")
    private WebElement selectCars;

    public W3SchoolsEditorPage getResultHeader() {
//        waitForElementToBeVisible(resultFrame);
        driver.switchTo().frame(iframeResult);
        System.out.println(resultHeader.getText());
        return this;
    }

    public W3SchoolsEditorPage switchToTheResultWindow() {
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        windows.remove(parentWindow);
        String secondWindow = windows.iterator().next();
        driver.switchTo().window(secondWindow);
        return this;
    }

    public W3SchoolsEditorPage selectCar(Cars carValue) {
        new Select(selectCars).selectByValue(carValue.getValue());
        return this;
    }

    public W3SchoolsEditorPage getSelectedCarDetails() {
        Select cars = new Select(selectCars);
        WebElement selectedOption = cars.getFirstSelectedOption();
        System.out.println("Selected car value: " + selectedOption.getAttribute("value")
                + " Selected car text: " + selectedOption.getText());
        return this;
    }
}