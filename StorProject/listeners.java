package StorProject;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class listeners extends StoreApp implements ITestNGListener
{
  
    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("----------- Test " + arg0 + " Faild -----------");
        saveScreenshot(getDriver());
        saveLogs(arg0.getMethod().getConstructorOrMethod().getName());
    }


    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("----------- Test " + arg0 + " Success -----------");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLogs(String message) {
        return message;
    }
}
