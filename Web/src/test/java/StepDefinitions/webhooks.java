package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.Base;

public class webhooks extends Base {
    @Before
    public void BeforeScenarios() {
        launchBrowser();
    }

    @After
    public void AfterScenario() {
        closeBrowser();
    }

}
