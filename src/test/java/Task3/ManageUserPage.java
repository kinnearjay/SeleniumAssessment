package Task3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ManageUserPage {
    @FindBys(@FindBy(tagName = "a"))
    private List<WebElement> usersList;
    public void checkIfUserCreated(String uName){
        for(int i = 0; i < usersList.size();i++){
            if(usersList.get(i).getText().equals(uName)){
                usersList.get(i).click();
            }

        }


    }
}
