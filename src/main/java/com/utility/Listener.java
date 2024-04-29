package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
 
public class Listener extends Base implements ITestListener {
    private static final TakesScreenshot driver = null;
	ExtentReports extent = ExtentReportGenerator.getreport();
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
    static Logger logger = LogManager.getLogger(Listener.class);
 
    public void onTestStart(ITestResult result) {
        String methodName = result.getTestClass().getName() + "==" + result.getMethod().getMethodName();
        logger.info("*****************************************  " + methodName
                + "  *****************************************************");
 
        ExtentTest test = extent.createTest(methodName);
        extenttest.set(test);
    }
 
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS, "Test Case Passed.");
        extenttest.get().addScreenCaptureFromBase64String(getScreenshot());
    }
 
    public void onTestFailure(ITestResult result) {
        extenttest.get().log(Status.FAIL, "Test Case Failed.");
        extenttest.get().addScreenCaptureFromBase64String(getScreenshot());
    }
 
    public void onTestSkipped(ITestResult result) {
        extenttest.get().log(Status.SKIP, "Test Case Skipped.");
    }
 
    public void onFinish(ITestContext context) {
        extent.flush();
    }
 
    public static String getScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}
