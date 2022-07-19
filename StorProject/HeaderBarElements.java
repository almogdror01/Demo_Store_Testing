package StorProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HeaderBarElements extends StoreApp
{
    @FindBy(xpath = "//ul[@id='ast-hf-menu-1']/li/a")
    private List<WebElement> links_Bar;

    @FindBy (xpath = "//div[@class='ast-search-icon']/a")
    private WebElement link_searchIcon;

    public void barlinksFunctionality()
    {
        for (WebElement link:links_Bar) {
            if (link.getText().equals("ACCESSORIES")) {
                link.click();
                break;
            }
        }

    }




}
