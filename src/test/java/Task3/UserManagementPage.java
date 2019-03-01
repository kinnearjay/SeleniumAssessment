package Task3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class UserManagementPage {
    @FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[1]/img")
    private WebElement configBTN;
    public void clickConfigBTN(){
        configBTN.click();
    }

    @FindBy(name = "_.fullName")
    private WebElement fullNameBox;
    public void changeFullName(String name){
        fullNameBox.clear();
        fullNameBox.sendKeys(name);

    }
    @FindBy(id = "yui-gen2-button")
    private WebElement saveBTN;
    public void setNewName(){
        saveBTN.click();

    }
    @FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
    private WebElement peopleBTN;
    public void clickPeopleBTN(){
        peopleBTN.click();
    }
}

