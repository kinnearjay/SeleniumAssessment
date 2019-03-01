package Task3;

import Task1.DashboardPage;
import Task1.LandingPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class StepDefinition {
    WebDriver driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^I go to \"([^\"]*)\" website$")
    public void i_go_to_website(String arg1) {
        driver.get(arg1);
       Task1.LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
       lp.logIn();
       Task1.DashboardPage dp = PageFactory.initElements(driver, DashboardPage.class);
       dp.createUser(driver);
       driver.navigate().back();


    }

    @Given("^the username is present \"([^\"]*)\"$")
    public void the_username_is_present(String arg1)  {
        Task1.DashboardPage dp = PageFactory.initElements(driver, DashboardPage.class);
        dp.checkIfUserCreated(arg1);

    }

    @When("^I click on username \"([^\"]*)\"$")
    public void i_click_on_username(String arg1)   {
        ManageUserPage mup = PageFactory.initElements(driver,ManageUserPage.class);
        mup.checkIfUserCreated(arg1);

    }

    @When("^I click on configure link$")
    public void i_click_on_configure_link() {
        UserManagementPage ump = PageFactory.initElements(driver,UserManagementPage.class);
        ump.clickConfigBTN();
    }

    @When("^change the current fullname to new a new fullname \"([^\"]*)\"$")
    public void change_the_current_fullname_to_new_a_new_fullname(String arg1)  {
        UserManagementPage ump = PageFactory.initElements(driver,UserManagementPage.class);
        ump.changeFullName(arg1);
    }

    @When("^I click save button$")
    public void i_click_save_button() {
        UserManagementPage ump = PageFactory.initElements(driver,UserManagementPage.class);
        ump.setNewName();
    }

    @When("^I click on People link$")
    public void i_click_on_People_link() {
        UserManagementPage ump = PageFactory.initElements(driver,UserManagementPage.class);
        ump.clickPeopleBTN();
    }

    @Then("^the new fullname \"([^\"]*)\" should be visible for the username \"([^\"]*)\"$")
    public void the_new_fullname_should_be_visible_for_the_username(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
