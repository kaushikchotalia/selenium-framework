package com.kaushik.testcaes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.kaushik.config.FrameWorkConfig;
import com.kaushik.drivermanager.DriverManager;
import com.kaushik.pages.*;
import com.kaushik.reports.ExtentHTMLReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TopNavigationTest {
    WebDriver driver;
    TopNavBarPage topNavBar;
    ExtentTest test;
    LiveDemoPage liveDemoPage;
    WebDriverWait wait;
    ZoomVideoTutorialsPage zoomVideoTutorialsPage;
    LiveTrainingWebinarPage liveTrainingWebinarPage;
    EventsPage eventsPage;
    ZoomBlogPage zoomBlogPage;
    FAQPage faqPage;

    @BeforeSuite
    public void setUp()
    {
        ExtentReports reports = ExtentHTMLReport.getReports();
        driver = DriverManager.getDriver();
        driver.get(FrameWorkConfig.getProperty("app.url"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("truste-consent-button")));
        btn.click();
        test = reports.createTest("TopNavigationTest");
    }

    @Test (enabled = false)
    public void testRequestDemoLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        liveDemoPage = topNavBar.clickRequestDemo();
        Assert.assertEquals("Request a Demo",liveDemoPage.getTextFromLiveDemoPage().getText());
    }

    @Test (enabled = false)
    public void testVideoTutorialsLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        zoomVideoTutorialsPage = topNavBar.clickVideoTutorialsLink();
        String str = zoomVideoTutorialsPage.getZoomVideoTutorialsPageText().getText();
        String str1 = str.trim();
        Assert.assertEquals("Zoom Video Tutorials",str1);
    }

    @Test (enabled = false)
    public void testLiveTrainigWebinarsLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        liveTrainingWebinarPage = topNavBar.clickLiveTrainingLink();
        String str = liveTrainingWebinarPage.LiveTrainingWebinarText.getText();
        String str1 = str.trim();
        Assert.assertEquals("Live Training Webinars",str1);
    }

    @Test (enabled = false)
    public void testEventsPageLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        eventsPage = topNavBar.clickWebinarsAndEventLink();
        String str = eventsPage.getEventaPageText().getText();
        String str1 = str.trim();
        Assert.assertEquals("Webinars & Events",str1);
    }

    @Test (enabled = false)
    public void testZoomBlogPageLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        zoomBlogPage = topNavBar.clickZoomBlogLink();
        String str = zoomBlogPage.getSubscribetoBlogText().getText();
        String str1 = str.trim();
        Assert.assertEquals("Subscribe to Blog",str1);
    }

    @Test (enabled = true)
    public void testFaqLinkValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        faqPage = topNavBar.clickFaqLink();
        String str = faqPage.getFaqPageText().getText();
        String str1 = str.trim();
        Assert.assertEquals("Frequently Asked Questions",str1);
    }

    @Test(enabled = false)
    public void requestDemoFormValidation()
    {
        topNavBar = new TopNavBarPage(driver);
        liveDemoPage = topNavBar.clickRequestDemo();
        liveDemoPage
                .keyInEmail("abc@xyz.com")
                .keyInCompany("Pragra")
                .keyInFirstName("Kaushik")
                .keyInLastName("Chotalia")
                .keyInTotalEmployee()
                .keyInPhone("123-456-7890")
                .keyInCountry()
                .keyInProvience()
                .keyInZipCode("l6q4r2")
                .keyAdditionalInformation("This is a test performed. Please ignore this message");
       liveDemoPage.submitForm();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.getDriver().quit();
    }
}
