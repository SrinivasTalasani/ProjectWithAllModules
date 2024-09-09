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

    public stepDefinition() {
        objectsPage = new Objects(driver);

    }

    @Given("User navigate to URL")
    public void user_navigate_to_url() {
        driver.get("https://www.ebay.com/");
    }

    @When("User enters the product what is looking for{string}")
    public void userEntersTheProductWhatIsLookingFor(String product) {
        objectsPage.userSearchesProduct(product);
    }

    @Then("User verifies the page")
    public void userVerifiesThePage() {
    }
}
