package StoreProject;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class listeners extends StoreApp implements ITestListener
{

    public void onTestFailure(ITestResult arg0)
    {
        saveScreenshot();
    }


    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("----------- Test " + arg0 + " Success -----------");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
