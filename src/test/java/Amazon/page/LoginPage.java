package Amazon.page;

import Amazon.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Amazon.driver.BaseTest.driver;
public class LoginPage {

    Methods methods;

    public LoginPage() {
        methods = new Methods();

    }

    public void page() {

        String strUrl = driver.getCurrentUrl();
        if (strUrl.contains("https://www.amazon.com.tr/")) {
            System.out.println("Dogru Sayfa");
        }
        methods.findElement(By.id("sp-cc-accept")).click();
        methods.waitBySeconds(1);
    }

    public void userlogin() {

        methods.click(By.id("nav-link-accountList"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(("input[class='a-input-text a-span12 auth-autofocus auth-required-field']")));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("ap_email"),"talhaertugrul.comez@testinium.com");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".a-button-input"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("ap_password"),"1A2B3C4d5f.");
        methods.waitBySeconds(1);
        methods.click(By.id("signInSubmit"));
        methods.waitBySeconds(1);

    }

}