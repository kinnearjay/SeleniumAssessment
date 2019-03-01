package Task1;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage {

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[1]/img")
    private WebElement addNewItemBTN;
    public void addItemBTN(){
        addNewItemBTN.click();
    }

    @FindBys
    (@FindBy(tagName = "a"))
    private List<WebElement> projectCreated;
    public Boolean projectCreatedSuccessfully(String item){
        for (int i = 0; i< projectCreated.size();i++){
            if(projectCreated.get(i).getText().equals(item)){
                return true;
            }
        }

        return false;
    }
    @FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
    private WebElement manageBTN;
    @FindBy(className = "icon-new-user")
    private WebElement newUserIcon;
    public void createUser(WebDriver driver){
        manageBTN.click();
        WebElement myDynamicElement = (new WebDriverWait(driver,15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-panel\"]/div[16]/a/img")));
        myDynamicElement.click();
        myDynamicElement = (new WebDriverWait(driver,15)).until(ExpectedConditions.presenceOfElementLocated(By.className("icon-new-user")));
        myDynamicElement.click();

    }
    @FindBys(@FindBy(tagName = "a"))
    private List<WebElement> usersList;
    public Boolean checkIfUserCreated(String uName){
        for(int i = 0; i < usersList.size();i++){
            if(usersList.get(i).getText().equals(uName)){
                return true;
            }

        }
        return false;

    }


}
