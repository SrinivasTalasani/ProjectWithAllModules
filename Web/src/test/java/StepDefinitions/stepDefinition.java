package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.Base;
import pageObjects.Objects;


public class stepDefinition extends Base {

//    WebDriver driver;
    Objects objectsPage;
    public stepDefinition(){
         objectsPage =new Objects(driver);

    }
    @Given("User navigate to URL")
    public void user_navigate_to_url() {
       // driver.get("https://ui.cogmento.com/");
    }

    @When("^User enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterAnd(String us1, String pa1) throws Throwable {
            objectsPage.emailAndPassword(us1,pa1);


    }
    @Then("User clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        System.out.println("second step");
        driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
        Thread.sleep(5000);
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Cogmento CRM",title);
    }
    @Then("User verify home page")
    public void user_verify_home_page() throws InterruptedException {
        System.out.println("third step");



    }



}
