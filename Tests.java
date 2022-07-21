import StorProject.HeaderBarElements;
import StorProject.StoreApp;
import StorProject.listeners;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({listeners.class})

public class Tests extends StoreApp {

    @BeforeClass
    public void openBrowser()
    {
        initialize();
        getDriver().get(getData("url",0));
    }

    @Test(description = "Test case 01.")
    @Description("Test Descriotion: case 01.")
    public void test01() {
        barElem.chooseBarLink(getData("BarLinkName",4));
        accessories.selectFilterAccessories(getData("SortBy",4));
        verify.assertEqualsfun(accessories.getResultCountAccessories(), accessories.getResultCountAccessories());
        accessories.accessoriesProductsName();
        verify.verifyTheMinNumOfStar(accessories.theNumberOfStar(),3);
    }
}
