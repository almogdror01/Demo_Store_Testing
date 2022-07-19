package StorProject;

import io.qameta.allure.Step;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

public class VerifyElements extends StoreApp
{
   @Step("Assert Equals")
   public void assertEqualsfun(String actual, String expected)
    {
        assertEquals(actual,expected);
    }

}
