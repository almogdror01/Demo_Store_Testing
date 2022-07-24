package StoreProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements
{
    @FindBy(xpath = "//div[@class='elementor-section-wrap']/section[1]/div[2]/div/div/div[4]/div/div/a")
    private WebElement btn_shopNow;

    @FindBy(xpath = "//div[@class='elementor-section-wrap']/section[1]/div[2]/div/div/div[5]/div/div/a")
    private WebElement btn_dindMore;

    @FindBy (className = "eicon-chevron-left")
    private WebElement arrow_left;

    @FindBy (className = "eicon-chevron-right")
    private WebElement arrow_right;

    public void clickOnShopNow()
    {
        btn_shopNow.click();
    }

}
