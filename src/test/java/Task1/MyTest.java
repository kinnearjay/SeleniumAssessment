package Task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    WebDriver driver;
    String url ="http://35.197.206.209:8080/login?from=%2F";
    public static List<String> projName;

    @BeforeClass
    public static void doMeFirst(){
        projName = new ArrayList<String>();
        projName.add("AutomatedItem");
    }
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void logUsrIn(){
        driver.get(url);
        LandingPage lp = PageFactory.initElements(driver,LandingPage.class);
        lp.logIn();
        DashboardPage dp = PageFactory.initElements(driver,DashboardPage.class);
        dp.addItemBTN();
        CreateItemPage cip = PageFactory.initElements(driver,CreateItemPage.class);
        cip.nameTheItem(driver,projName.get(0).toString());
        ConfigurePage cp = PageFactory.initElements(driver,ConfigurePage.class);
        cp.saveConfig();
        BackToDashboardPage btdbp = PageFactory.initElements(driver,BackToDashboardPage.class);
        btdbp.backToDash();
        Assert.assertEquals("File item not successfuly created",true,dp.projectCreatedSuccessfully(projName.get(0).toString()));

    }


}
