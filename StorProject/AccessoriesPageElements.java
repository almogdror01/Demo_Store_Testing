package StoreProject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccessoriesPageElements extends StoreApp
{
    Select defaultSorting;

    @FindBy(className = "woocommerce-result-count")
    private WebElement txt_resultsNumber_Accessories;

    @FindBy(xpath = "//ul[@class='products columns-4']/li/div[2]/a/h2")
    private List<WebElement> txt_products_Accessories;

    @FindBy(xpath = "//ul[@class='products columns-4']/li/div[2]/div/span")
    private List<WebElement> txt_productsStars_Accessories;

    @FindBy(name = "orderby")
    private WebElement btn_selectSort_Accessories;

    public String getAccessoriesProductsNum()
    {
        int num = txt_products_Accessories.size();
        String s = Integer.toString(num);
        return s;
    }
    @Step ("Select filter on the Accessories page.")
        public void selectFilterAccessories(String select) {
        defaultSorting = new Select(btn_selectSort_Accessories);
        defaultSorting.selectByVisibleText(select);
    }

    @Step ("Returns the total number of items on the Accessories page.")
    public String getResultsNumAccessories()
    {
        String arr[] = txt_resultsNumber_Accessories.getText().split("all ");
        String arr2[] = arr[1].split(" ");
        String numOfResultCount = arr2[0];
        return numOfResultCount;
    }

    @Step ("Returns the names of all the items on the Accessories page.")
    public String[] accessoriesProductsName()
    {
        String[] accessoriesProductsName= new String[txt_products_Accessories.size()];
        int i = 0;
        for (WebElement product:txt_products_Accessories)
        {
            accessoriesProductsName[i] = product.getText();
            i++;
        }
        return accessoriesProductsName;
    }

    @Step ("Returns an array with stars of all products on the Accessories page")
    public double[] theNumberOfStar()
    {
        double[] allProNumStarArr = new double[txt_productsStars_Accessories.size()];

            int i = -1;
            for (WebElement starProd:txt_productsStars_Accessories) {
                i++;
                String[] arr = starProd.getAttribute("style").split(": ");
                String[] arr2 = arr[1].split("%");
                allProNumStarArr[i] = Double.parseDouble(arr2[0]);;
            }
        return allProNumStarArr;
    }

    @Step("Verify the total number of items.")
    public void verifyTheTotalNumOfItems()
    {
        String expectedNumOfItems = "7";
        assertEquals(getResultsNumAccessories(),expectedNumOfItems);
    }


}
