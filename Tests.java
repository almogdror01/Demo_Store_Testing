import StorProject.HeaderBarElements;
import StorProject.StoreApp;
import StorProject.listeners;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({listeners.class})

public class Tests extends StoreApp {

    @Test(description = "Test case 01.")
    @Description("Test Descriotion: case 01.")
    public void test01() throws InterruptedException {
        barElem.chooseBarLink(getData("BarLinkName",4));
        accessories.selectFilterAccessories(getData("SortBy",4));
        verify.assertEqualsfun(accessories.getResultCountAccessories(), accessories.getResultCountAccessories());
        accessories.accessoriesProductsName();
        verify.verifyTheMinNumOfStar(accessories.theNumberOfStar(),3);
    }
}