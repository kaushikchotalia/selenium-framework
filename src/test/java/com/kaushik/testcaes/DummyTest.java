package com.kaushik.testcaes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.kaushik.config.FrameWorkConfig;
import com.kaushik.drivermanager.DriverManager;
import com.kaushik.reports.ExtentHTMLReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

//@Listeners({ScreenshotListener.class})
public class DummyTest {
    WebDriver driver;
    WebDriverWait wait;
    ExtentTest test;

    @BeforeSuite
    public void setUp()
    {
        ExtentReports reports = ExtentHTMLReport.getReports();
        driver = DriverManager.getDriver();
       wait = new WebDriverWait(driver,20);
       driver.get(FrameWorkConfig.getProperty("app.url"));
                driver.manage().window().maximize();
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("truste-consent-button")));
        btn.click();
        test = reports.createTest("DummyTest");

    }

   @Test
    public void testDummy(){
        // To demonstrate properties are being loaded correctly from framework.properties file
        //System.out.println(FrameWorkConfig.getProperty("browser"));

        //Check if WebDriverManager is working
        DriverManager.getDriver().get(FrameWorkConfig.getProperty("app.url"));
        test.log(Status.PASS,"WebDriver is able to get URL successfully");
    }

    /*@Test
    public void validateListnerTest()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Sales"))).click();
        Assert.fail();
    }*/

    /*@Test
    public void slecetNumOfEmpTest()
    {
        TopNavBar navBar = new TopNavBar(driver);
        LiveDemoPage liveDemoPageobj = new LiveDemoPage(driver);
        navBar.clickRequestDemo();
        liveDemoPageobj.selectEmployee(driver);
        *//*WebElement selectEmp = driver.findElement(By.id("00Nd0000007MFAl"));
        Select selectNumberOfEmployee = new Select(selectEmp);
        selectNumberOfEmployee.selectByVisibleText("Just Me");*//*
    }*/

    @AfterSuite

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
        ExtentHTMLReport.getReports().flush();
        DriverManager.getDriver().quit();
    }
}
