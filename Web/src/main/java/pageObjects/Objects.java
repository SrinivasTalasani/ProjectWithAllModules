package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Objects extends Base {

    public Objects(WebDriver driver){
        super(driver);
    }
    @FindBy(name="email")
    public WebElement email;

    @FindBy(name="password")
    public WebElement password;



    public void emailAndPassword(String usn, String pwd) {
        email.sendKeys(usn);
        password.sendKeys(pwd);
    }

}
