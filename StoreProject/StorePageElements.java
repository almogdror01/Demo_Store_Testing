package StoreProject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePageElements extends StoreApp
{
    @FindBy(xpath = "//div[@class='price_slider_wrapper']/div/span")
    private WebElement slider_left;

    @FindBy(xpath = "//div[@class='price_slider_wrapper']/div/span[2]")
    private WebElement slider_rigth;

    @FindBy(xpath = "//div[@class='price_slider_amount']/button")
    private WebElement btn_filter;

    @FindBy(xpath = "//div[@class='astra-shop-thumbnail-wrap']/a")
    private WebElement a_firstProduct;

    @FindBy(name = "add-to-cart")
    private WebElement btn_addToCart;

    @FindBy(xpath = "//div[@class='woocommerce-message']/a")
    private WebElement a_viewCart;

    @Step("Slider Filter")
    public void sliderFilter(int start, int end) {
        int startPx = 4 + howManyPxShouldBeMoved(start,30);
        double endPx = 1 + howManyPxShouldBeMoved(end,250);

        for (int i = 0; i <= startPx; i++) {
            action.dragAndDropBy(slider_left,i,0).build().perform();
        }
        for (int i = 5; i <= endPx; i++) {
            action.dragAndDropBy(slider_rigth,(-i),0).build().perform();
        }

        btn_filter.click();
    }
    @Step("Pick First Product")
    public void pickFirstProduct()
    {
        a_firstProduct.click();
    }

    @Step("Add To Cart")
    public void addToCart()
    {
        btn_addToCart.click();
    }

    @Step("Add To Cart After View Cart")
    public void viewCartAfter_AddToCart()
    {
        a_viewCart.click();
    }
    @Step("How Many Px Should Be Moved")
    public int howManyPxShouldBeMoved(int price, int startNum)
    {
        int pxNum = 0;
        if (startNum == 30){
            while (startNum <= price)
            {
                startNum += 10;
                pxNum++;
            }
        }
        else {
            while (startNum >= price)
            {
                startNum -= 10;
                pxNum++;
            }
        }
        return pxNum;

    }

}