import StoreProject.StoreApp;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(StoreProject.listeners.class)
public class Tests extends StoreApp {

    @BeforeClass
    public void openBrowser() {
        initialize();
        openHomePage();
    }

    @Test(description = "Test case 01.")
    @Description("Test Description: case 01.")
    public void test01() {
        barElem.chooseBarLink(getData("BarLinkName",4));
        accessories.selectFilterAccessories(getData("SortBy",4));
        accessories.verifyTheTotalNumOfItems();
        accessories.accessoriesProductsName();
        verify.verifyTheMinNumOfStar(accessories.theNumberOfStar(),3);
    }

    @Test(description = "Test case 02.")
    @Description("Test Description: case 02.")
    public void test02() {
        homePageElem.clickOnShopNow();
        storePageElem.sliderFilter(50,90);
        storePageElem.pickFirstProduct();
        storePageElem.addToCart();
        storePageElem.viewCartAfter_AddToCart();
        cartPageElem.addCoupon("example");
        cartPageElem.confirmCoupon("example");
    }


}