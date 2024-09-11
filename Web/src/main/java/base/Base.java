package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    public static WebDriver driver;

    public Base() {


    }

    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

// @Before
    public void launchBrowser() {
        setupWebDriver();

    }

    public WebDriver setupWebDriver() {
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\srini\\Downloads\\msedgedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        return driver;
    }

//        @After
    public void closeBrowser() {
        driver.quit();
    }
}
