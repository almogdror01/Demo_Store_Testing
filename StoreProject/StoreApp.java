package StoreProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;


public class StoreApp
{
    static WebDriver driver;
    static Actions action;
    protected HeaderBarElements barElem;
    protected HomePageElements homePageElem;
    protected FooterElements footerElem;
    protected VerifyElements verify;
    protected StorePageElements storePageElem;
    protected CartPageElements cartPageElem;
    protected AccessoriesPageElements accessories;

    @Step("Initialize")
    public void initialize()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        homePageElem = PageFactory.initElements(driver, HomePageElements.class);
        barElem = PageFactory.initElements(driver, HeaderBarElements.class);
        footerElem = PageFactory.initElements(driver, FooterElements.class);
        verify = PageFactory.initElements(driver, VerifyElements.class);
        storePageElem = PageFactory.initElements(driver, StorePageElements.class);
        cartPageElem = PageFactory.initElements(driver, CartPageElements.class);
        accessories = PageFactory.initElements(driver, AccessoriesPageElements.class);
        action = new Actions(driver);
    }


    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }

    @AfterTest
    public void closeSession()
    {
        openHomePage();
    }

    @Step
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

    public static WebDriver getDriver()
    {
        return driver;
    }

    public void openHomePage()
    {
        getDriver().get(getData("url", 0));
    }
}
