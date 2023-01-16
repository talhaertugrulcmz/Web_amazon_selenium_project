package Amazon.methods;

import Amazon.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public String getAttribute(By by, String attirubuteName) {
        return findElement(by).getAttribute(attirubuteName);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void sendKeys(String s) {
    }

    By productselected = By.cssSelector("span.a-size-base-plus");
    private List<WebElement> getAllProducts() {
        return findAll(productselected);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public By selectProduct(String s,int i) {
        getAllProducts().get(i).click();
        return null;
    }
    public void hoverElement(By by){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void hoverElement(WebElement element) {
    }
}
