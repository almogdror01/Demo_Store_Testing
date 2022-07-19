package StorProject;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerifyElements extends StoreApp
{
   @Step("Assert Equals")
   public void assertEqualsfun(String actual, String expected)
    {
        assertEquals(actual,expected);
    }

    @Step("Assert True")
    public void assertTruefun(Boolean b)
    {
        assertTrue(b);
    }

    @Step("Checks the number of stars of the products.")
    public void verifyTheMinNumOfStar(double [] arr, int num)
    {
        for (int i = 0; i < arr.length; i++) {
            assertTruefun(arr[i] >= Integer.parseInt(getData("Star",num)));
        }

    }



}
