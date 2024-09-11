package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import base.Base;
import pageObjects.Objects;

public class Tests extends Base {


    @Test
    public void login() {
        launchBrowser();
        Reporter.log("Browser launched and entered URL");
        Objects ob = new Objects(driver);
        ob.userSearchesProduct("goods");

        closeBrowser();
        Reporter.log("Browser closed");
    }
}
