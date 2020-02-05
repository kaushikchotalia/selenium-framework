package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZoomBlogPage {
    WebDriver driver;

    public ZoomBlogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".explore span:nth-child(3)")
    public WebElement SubscribetoBlogText;

    public WebElement getSubscribetoBlogText()
    {
        return SubscribetoBlogText;
    }
}
