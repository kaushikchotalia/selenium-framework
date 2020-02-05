package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {
    WebDriver driver;

    public EventsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".events-content>div>h1")
    public WebElement EventaPageText;

    public WebElement getEventaPageText() {
        return EventaPageText;
    }
}
