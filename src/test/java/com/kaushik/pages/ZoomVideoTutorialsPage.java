package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZoomVideoTutorialsPage {
    WebDriver driver;

    //Constructor to get driver and to get all elements on the page
    public ZoomVideoTutorialsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".main-column header h1:first-child")
    public WebElement ZoomVideoTutorialsPageText;

    public WebElement getZoomVideoTutorialsPageText()
    {
        return ZoomVideoTutorialsPageText;
    }
}
