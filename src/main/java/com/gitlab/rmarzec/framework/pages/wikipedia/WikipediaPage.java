package com.gitlab.rmarzec.framework.pages.wikipedia;

import com.gitlab.rmarzec.framework.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikipediaPage extends BasePage {

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='p-lang-btn-checkbox']")
    private WebElement languagesDropdownBtn;

    @FindBy(css = ".row.uls-language-list")
    private WebElement listOfLanguages;

    @FindBy(css = ".uls-language-block li>a")
    private List<WebElement> languagesList;

    public WikipediaPage expandLanguagesDropdown() {
        languagesDropdownBtn.click();
        return this;
    }

    public WikipediaPage displayLanguagesName() {
        waitForElementToBeVisible(listOfLanguages);
        boolean foundEnglish = false;
        for (WebElement language : languagesList) {
            if (language.getText().equals("English") && !foundEnglish) {
                System.out.println("Language: " + language.getText() + " URL: " + language.getAttribute("href"));
                foundEnglish = true;
            } else if (!language.getText().equals("English")) System.out.println("Language: " + language.getText());
        }
        return this;
    }

    /* I have added this method to show other possibility */
    public WikipediaPage ternaryOperation() {
        waitForElementToBeVisible(listOfLanguages);
        for (WebElement language : languagesList) {
            String englishLanguage = "Language: " + language.getText() + " URL: " + language.getAttribute("href");
            String otherLanguage = "Language: " + language.getText();

            String message = language.getText().equals("English") ? englishLanguage : otherLanguage;
            System.out.println(message);
        }
        return this;
    }
}