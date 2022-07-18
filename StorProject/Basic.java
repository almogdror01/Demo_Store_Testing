package StorProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class Basic
{
    WebDriver driver;
    Actions action;
    HeaderBarElements barElem;
    HomePageElements homePageElem;
    FooterElements footerElem;
    VerifyElements verifyElem;
    StorePageElements storePageElem;
    CartPageElements cartPageElem;

    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(getData("url",0));

        homePageElem = PageFactory.initElements(driver, HomePageElements.class);
        barElem = PageFactory.initElements(driver, HeaderBarElements.class);
        footerElem = PageFactory.initElements(driver, FooterElements.class);
        verifyElem = PageFactory.initElements(driver, VerifyElements.class);
        storePageElem = PageFactory.initElements(driver, StorePageElements.class);
        cartPageElem = PageFactory.initElements(driver, CartPageElements.class);
        action = new Actions(driver);


    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }

    public String getData (String nodeName, int index)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:\\automation\\TestAutomation\\AtidStoreProject\\TestConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(index).getTextContent();
    }

}
