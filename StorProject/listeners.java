package StorProject;

import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class listeners extends StoreApp implements ITestNGListener
{
    public void onFinish(ITestContext arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("----------- Test " + arg0 + " Faild -----------");
    }

    public void onTestSkipped(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("----------- Test " + arg0 + " Success -----------");
    }
}
