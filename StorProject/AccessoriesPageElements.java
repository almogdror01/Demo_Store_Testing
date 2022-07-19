package StorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import java.util.List;
@Listeners({listeners.class})
public class AccessoriesPageElements extends StoreApp
{
    Select defaultSorting;

    @FindBy(className = "woocommerce-result-count")
    private WebElement resultCountAccessories;

    @FindBy(xpath = "//ul[@class='products columns-4']/li/div[2]/a/h2")
    private List<WebElement> txt_products;


    public String getAccessoriesProductsNum()
    {
        int num = txt_products.size();
        String s = Integer.toString(num);
        return s;
    }
    public void selectFilterAccessories(String select, WebDriver driver) {
        defaultSorting = new Select(driver.findElement(By.name("orderby")));
        defaultSorting.selectByVisibleText(select);
    }

    public String getResultCountAccessories()
    {
        String arr[] = resultCountAccessories.getText().split("all ");
        String arr2[] = arr[1].split(" ");
        String numOfResultCount = arr2[0];
        return numOfResultCount;
    }

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
}
