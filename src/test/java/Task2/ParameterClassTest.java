package Task2;

import Task1.DashboardPage;
import Task1.LandingPage;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterClassTest {
    WebDriver driver ;
    String url ="http://35.197.206.209:8080/login?from=%2F";


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\AssessmentFriday.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);
        Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][5];

        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            for (int colNum = 0; colNum < 5; colNum++) {
                ob[rowNum-1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            }
        }
        return Arrays.asList(ob);
    }

    private String usrName;
    private String fullName;
    private String passWord;
    private String confirmPassWord;
    private String usrEmail;

    public ParameterClassTest(String usrName, String fullName, String passWord, String confirmPassWord, String usrEmail) {
        this.usrName = usrName;
        this.fullName = fullName;
        this.passWord = passWord;
        this.confirmPassWord = confirmPassWord;
        this.usrEmail = usrEmail;
    }
    @Test
    public void createUsers(){
        driver.get(url);
        Task1.LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
        lp.logIn();
        Task1.DashboardPage dp = PageFactory.initElements(driver,DashboardPage.class);
        dp.createUser(driver);
        CreateUserPage cup = PageFactory.initElements(driver,CreateUserPage.class);
        cup.registerUsr(usrName,passWord,confirmPassWord,fullName,usrEmail);
        Assert.assertEquals("user not created",true,dp.checkIfUserCreated(usrName));


    }
}
