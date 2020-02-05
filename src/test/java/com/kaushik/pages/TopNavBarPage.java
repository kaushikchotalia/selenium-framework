package com.kaushik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavBarPage {
    WebDriver driver;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(1)>a")
    private WebElement requestADemoLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(2)>a")
    private WebElement one888Number;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>a")
    private WebElement resources;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(4)>a")
    private WebElement support;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(1)")
    private WebElement downLoadZoomClientLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(3) a")
    private WebElement videoTutorialsLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(5) a")
    private WebElement liveTrainingLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(7) a")
    private WebElement webinarsAndEventLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(9) a")
    private WebElement zoomBlogLink;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)>ul>li:nth-child(11) a")
    private WebElement faqLink;



    public TopNavBarPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LiveDemoPage clickRequestDemo()
    {
        this.requestADemoLink.click();
        return new LiveDemoPage(driver);
    }

    public DownloadCenterPage clickDownLoadZoomClintLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(downLoadZoomClientLink).click().build().perform();
        return new DownloadCenterPage(driver);
    }
    public ZoomVideoTutorialsPage clickVideoTutorialsLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(videoTutorialsLink).click().build().perform();
        return new ZoomVideoTutorialsPage(driver);
    }

    public LiveTrainingWebinarPage clickLiveTrainingLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(liveTrainingLink).click().build().perform();
        return new LiveTrainingWebinarPage(driver);
    }

    public EventsPage clickWebinarsAndEventLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(webinarsAndEventLink).click().build().perform();
        return new EventsPage(driver);
    }

    public ZoomBlogPage clickZoomBlogLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(zoomBlogLink).click().build().perform();
        return new ZoomBlogPage(driver);
    }

    public  FAQPage clickFaqLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).pause(2000).moveToElement(faqLink).click().build().perform();
        return new FAQPage(driver);
    }



}
