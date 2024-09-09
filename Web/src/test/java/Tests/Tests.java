package Tests;

import org.junit.Test;
import pageObjects.Base;
import pageObjects.Objects;

public class Tests extends Base {


    @Test
    public void login() {
        Objects ob = new Objects(driver);
        ob.userSearchesProduct("goods");
    }
}
