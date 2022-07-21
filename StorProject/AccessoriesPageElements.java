package StorProject;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class AccessoriesPageElements extends StoreApp
{
    Select defaultSorting;

    @FindBy(className = "woocommerce-result-count")
    private WebElement resultCountAccessories;

    @FindBy(xpath = "//ul[@class='products columns-4']/li/div[2]/a/h2")
    private List<WebElement> txt_products;

    @FindBy(xpath = "//ul[@class='products columns-4']/li/div[2]/div/span")
    private List<WebElement> txt_productsStars;

    @FindBy(name = "orderby")
    private WebElement btn_selectSort;

    public String getAccessoriesProductsNum()
    {
        int num = txt_products.size();
        String s = Integer.toString(num);
        return s;
    }
    @Step ("Select filter accessories.")
        public void selectFilterAccessories(String select) {
        defaultSorting = new Select(btn_selectSort);
        defaultSorting.selectByVisibleText(select);
    }

    @Step ("Get result count accessories.")
    public String getResultCountAccessories()
    {
        String arr[] = resultCountAccessories.getText().split("all ");
        String arr2[] = arr[1].split(" ");
        String numOfResultCount = arr2[0];
        return numOfResultCount;
    }

    @Step ("Accessories products name.")
    public String[] accessoriesProductsName()
    {
        String[] accessoriesProductsName= new String[txt_products.size()];
        int i = 0;
        for (WebElement product:txt_products)
        {
            accessoriesProductsName[i] = product.getText();
            i++;
        }
        return accessoriesProductsName;
    }

    @Step ("Returns an array with stars of all products Accessories")
    public double[] theNumberOfStar()
    {
        double[] allProNumStarArr = new double[txt_productsStars.size()];

            int i = -1;
            for (WebElement starProd:txt_productsStars) {
                i++;
                String[] arr = starProd.getAttribute("style").split(": ");
                String[] arr2 = arr[1].split("%");
                allProNumStarArr[i] = Double.parseDouble(arr2[0]);;
            }
        return allProNumStarArr;
    }



}
