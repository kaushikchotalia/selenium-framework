package com.kaushik.reports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kaushik.util.FrameworkUtilities;

public class ExtentHTMLReport {
    private static ExtentReports reports;

    private ExtentHTMLReport()
    {
        ExtentReporter extentReporter = new ExtentHtmlReporter(FrameworkUtilities.getReportFileName());
        reports = new ExtentReports();
        reports.attachReporter(extentReporter);
    }

    public static ExtentReports getReports()
    {
        if(reports == null)
        {
            new ExtentHTMLReport();
        }
        return reports;
    }

}
