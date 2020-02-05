package com.kaushik.util;

import com.kaushik.config.FrameWorkConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameworkUtilities {
    private static String dateFormat = "ddMMyyyyHHmm";

    // Create Screenshot directories based on Pass, Fail or All status provided in Framework.Properties file
    private static void createScreenshotDirs()
    {
        try{
            if(FrameWorkConfig.getProperty("screenshotType").equals("pass"))
            {
                Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir")));
            }
            else if(FrameWorkConfig.getProperty("screenshotType").equals("fail"))
            {
                Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir")));
            }
            else
            {
                Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir")));
                Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir")));
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    public static String formatDate(Date date)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }

    public static String getScreenshotFile(String testName)
    {
        // Example Login_DD-MM-YYYY-HHmmSS
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-HHmmSS");
        return testName+"_"+simpleDateFormat.format(new Date())+".png";
    }

    public static void captureScreenshot(WebDriver driver, String testName, boolean pass)
    {
        createScreenshotDirs();
        File memoryScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = getScreenshotFile(testName);
        try{
            if(pass)
            {
                Path passFilePath = Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir"),fileName);
                Files.copy(new FileInputStream(memoryScreenShot),passFilePath);
            }
            else
            {
                Path failFilePath = Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir"),fileName);
                Files.copy(new FileInputStream(memoryScreenShot),failFilePath);
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

    }
    public static File getReportFileName()
    {
        Path file = null;
        try {
            Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("report.dir")));
            String fileName = FrameWorkConfig.getProperty("report.fileprefix") + "_" + formatDate(new Date()) + ".html";
            file = Paths.get(FrameWorkConfig.getProperty("report.dir"),fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.toFile();
    }


}
