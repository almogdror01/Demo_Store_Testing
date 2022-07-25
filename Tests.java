package org.StoreProject;

import org.StoreProject.StoreApp;
import io.qameta.allure.Description;
import org.StoreProject.listeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners(listeners.class)
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
    @Parameters({"startingPrice", "finalPrice","couponName"})
    public void test02(int startingPrice, int finalPrice, String couponName) {
        homePageElem.clickOnShopNow();
        storePageElem.sliderFilter(startingPrice,finalPrice);
        storePageElem.pickFirstProduct();
        storePageElem.addToCart();
        storePageElem.viewCartAfter_AddToCart();
        cartPageElem.addCoupon(couponName);
        cartPageElem.confirmCoupon(couponName);
    }


}