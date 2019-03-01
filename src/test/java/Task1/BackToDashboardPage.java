package Task1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackToDashboardPage {

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
    private WebElement backToDashBTN;
    public void backToDash(){
        backToDashBTN.click();
    }
}
