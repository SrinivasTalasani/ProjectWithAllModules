package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Enablers extends Base {
    public WebDriver wdriver;
    public JavascriptExecutor js;

    public Enablers(WebDriver wdriver) {
        this.wdriver = wdriver;
    }

    /**
     * @param element
     * @Description: This method is used click element if there are errors like stale element etc.
     */
    public void javaScriptExecutor(WebElement element) {

        js = (JavascriptExecutor) wdriver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * @Description: This method is used to scroll down by 250 pixel vertical in the web page
     */
    public void scrollDown() {

        js = (JavascriptExecutor) wdriver;
        js.executeScript("scroll(0, 250);");
    }

    /**
     * @Description: This method is used to scroll Up in the web page
     */

    public void scrollUp() {
        js = (JavascriptExecutor) wdriver;
        js.executeScript("window.scrollTo(0,0)");
    }

    /**
     * @Description: This method is used to scroll to the element in the web page
     */
//    public void scrollToElement(WebElement element) {
//
//        Coordinates cor = (Coordinates) ((Locatable) element).getCoordinates();
//        cor.inViewPort();
//    }

    /**
     * @Description: This method is used to scroll to the end of the page
     */
    public void scrollToEndOfPage() {
        ((JavascriptExecutor) wdriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * @Description: This method is used explicitly waiting for the element presence in the page
     */

    public WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(wdriver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * @Description: This method is used explicitly waiting for the element is clickable in the page
     */

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(wdriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }


    /**
     * @Description: Delay time in seconds to pause or hold for some page objects to load takes
     * only integer value of number of seconds to pause
     * * @param seconds
     */
    public void secondsDelay(int seconds) {
        int timeInMilliSeconds;
        try {
            timeInMilliSeconds = seconds * 1000;
            System.out.println("##############################################");
            System.out.println("Going for " + timeInMilliSeconds + " delay");
            System.out.println("##############################################");
            Thread.sleep(timeInMilliSeconds);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

//    /**
//     * @Description: This method to take screenshot
//     * * @param screenshotName
//     */
//    public void TakeScreenCapture(String screenshotName) throws IOException {
//        String timestamp = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
//        String encodedBase64 = null;
//        FileInputStream fileInputStream = null;
//        TakesScreenshot screenshot = (TakesScreenshot) wdriver;
//        File source = screenshot.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir") + "/target/cucumber-reports/WebReports/Screenshots/" + screenshotName + timestamp + ".png";
//        File finalDestination = new File(destination);
//        FileUtils.copyFile(source, finalDestination);
//
//        fileInputStream = new FileInputStream(finalDestination);
//        byte[] bytes = new byte[(int) finalDestination.length()];
//        fileInputStream.read(bytes);
//        encodedBase64 = new String(Base64.encodeBase64(bytes));
//        String img = "data:image/png;base64," + encodedBase64;
//
//        Reporter.addScreenCaptureFromPath(img);
//    }

    /**
     * @Description: This method used to click and element
     * * @param element
     */

    public boolean clickElement(WebElement element) {
        if (element.isDisplayed()) {
            element.click();
            return true;
        }
        return false;
    }

    /**
     * @Description: This method used to send keys in to the text box
     * * @param element,text
     */

    public boolean typeText(WebElement element, String text) {
        if (element.isDisplayed()) {
            element.sendKeys(text);
            return true;
        }
        return false;
    }

    /**
     * @Description: This method used to clear the text box
     * * @param element
     */

    public boolean clearText(WebElement element) {
        if (element.isDisplayed()) {
            element.clear();
            return true;
        }
        return false;
    }

    /**
     * @Description: This method used to verify the element present in the page
     * * @param element
     */

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void selectDropDownValue(WebElement strDDOpenerXpath, String strDDULXPath, String strValue) {
        secondsDelay(1);
        strDDOpenerXpath.click();
        secondsDelay(1);
        for (int i = 1; i <= 300; ++i) {
            try {
                String strResult = this.wdriver.findElement(By.xpath(strDDULXPath + "[" + i + "]")).getText();
                if (strResult.contains(strValue)) {
                    this.wdriver.findElement(By.xpath(strDDULXPath + "[" + i + "]")).click();
                    break;
                }
            } catch (Exception var7) {
                throw new ElementNotSelectableException("Dropdown selection failed for value " + strValue);
            }
        }

    }

    /**
     * @Description: This method used to implement implicit wait
     */
    public void implicitWait(int sec) {
        wdriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

}
