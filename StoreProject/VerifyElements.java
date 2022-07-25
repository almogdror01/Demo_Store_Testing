package StoreProject;

import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.*;

public class VerifyElements extends StoreApp
{
    @Step("Checks the number stars of the products.")
    public void verifyTheMinNumOfStar(double [] arr, int num)
    {
        for (int i = 0; i < arr.length; i++) {
            Assert.assertTrue(arr[i] >= Integer.parseInt(getData("Star",num)));
        }

    }






}
