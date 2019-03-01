package Task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
    @FindBy(name = "username")
    private WebElement usernameBox;
    @FindBy(name = "password1")
    private WebElement passwordBox;
    @FindBy(name = "password2")
    private WebElement confirmPasswordBox;
    @FindBy(name = "fullname")
    private WebElement fullNameBox;
    @FindBy(name = "email")
    private WebElement emailBox;
    @FindBy(id = "yui-gen1-button")
    private WebElement regBTN;
    public void registerUsr(String usrName, String pWord, String cPWord, String fName, String email){
        usernameBox.sendKeys(usrName);
        passwordBox.sendKeys(pWord);
        confirmPasswordBox.sendKeys(cPWord);
        fullNameBox.sendKeys(fName);
        emailBox.sendKeys(email);
        regBTN.click();


    }
}
