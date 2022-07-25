package StoreProject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertEquals;


public class CartPageElements extends StoreApp
{
    @FindBy(name = "coupon_code")
    private WebElement input_coupon_Cart;

    @FindBy(xpath = "//div[@class='coupon']/button")
    private WebElement btn_applyCoupon_Cart;

    @FindBy(xpath = "//tr[@class='order-total']/td/strong/span/bdi")
    private WebElement txt_totalPrice_Cart;

    @FindBy(xpath = "//tr[@class='cart-subtotal']/td/span/bdi")
    private WebElement txt_subTotalPrice_Cart;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement txt_errorMessage_Cart;


    @Step("Add Coupon")
    public void addCoupon(String couponName)
    {
        input_coupon_Cart.sendKeys(couponName);
        btn_applyCoupon_Cart.click();
    }
    @Step("Confirm Coupon")
    public void confirmCoupon(String couponName)
    {
        if (couponName.equals("example"))
        {
            String errorMessage = "51.00 ₪";
            assertEquals(txt_totalPrice_Cart.getText(),errorMessage,txt_errorMessage_Cart.getText());
        }
    }


}
