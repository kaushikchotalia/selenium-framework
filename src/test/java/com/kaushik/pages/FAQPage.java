package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage {
    WebDriver driver;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".main-content article header h1")
    public WebElement faqPageText;

    public WebElement getFaqPageText() {
        return faqPageText;
    }
}
