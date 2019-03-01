package Task1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
    @FindBy(name = "j_username")
    private WebElement usrName;
    @FindBy(name = "j_password")
    private WebElement usrPassW;
    @FindBy(name = "Submit")
    private WebElement submitInfo;
    public void logIn(){
        usrName.sendKeys("admin");
        usrPassW.sendKeys("admin");
        submitInfo.submit();

    }


}
