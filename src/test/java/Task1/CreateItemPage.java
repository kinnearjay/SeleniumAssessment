package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateItemPage {

    @FindBy(name = "name")
    private WebElement nameOfItem;
    @FindBys(@FindBy(className = "label"))
    private List<WebElement> labels;
    public void nameTheItem(WebDriver driver,String item){
        nameOfItem.sendKeys(item);
        for(int i = 0 ; i<labels.size(); i++){
                if(labels.get(i).getText().toLowerCase().contains("freestyle")) {
                    labels.get(i).click();
                }
                }


        WebElement myDynamicElement = (new WebDriverWait(driver,15)).until(ExpectedConditions.presenceOfElementLocated(By.id("ok-button")));
        myDynamicElement.click();

    }

}
