package pageObjects;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.Enablers;

import java.util.List;


public class Objects extends Base {
Enablers enablers = new Enablers(driver);
    public Objects(WebDriver driver){
        super(driver);
    }
    @FindBy(id="gh-ac")
    public WebElement searchBox;

    @FindBy(id="gh-btn")
    public WebElement searchButton;



    public void userSearchesProduct(String prd) {
        searchBox.sendKeys(prd);
        searchButton.click();

    }
    public void userSearchesProduct(WebElement element) {
JavascriptExecutor js = (JavascriptExecutor)driver;
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

}
