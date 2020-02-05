package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrainingWebinarPage {
    WebDriver driver;

    public LiveTrainingWebinarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".main-content article header h1:first-child")
    public WebElement LiveTrainingWebinarText;

    public WebElement getLiveTrainingWebinarText()
    {
        return LiveTrainingWebinarText;
    }
}
