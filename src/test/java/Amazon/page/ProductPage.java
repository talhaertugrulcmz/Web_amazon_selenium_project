package Amazon.page;


import Amazon.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static Amazon.driver.BaseTest.driver;

public class ProductPage {
    Random rand = new Random();
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void searchProduct() throws InterruptedException {

        WebElement productsearch = methods.findElement(By.id("twotabsearchtextbox"));
        productsearch.click();
        productsearch.sendKeys("Telefon");
        productsearch.sendKeys(Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]"));
        String trueproduct = sonuc.getText();

        if (trueproduct.contains("Telefon")){
            System.out.println("Dogru kelime aratildi");
        }else{
            System.out.println("Sonuç bulunamadı");
        }
    }

    public void selectedProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,700)");
        methods.waitBySeconds(2);

        methods.selectProduct("span.a-size-base-plus", 5);
        methods.waitBySeconds(2);

        String strUrl = driver.getCurrentUrl();
        if (strUrl.contains("https://www.amazon.com.tr/Apple-Telefon-Kulakl%C4%B1k-Adapt%C3%B6r-Garantili/dp/B08PPYCQM9/ref=sr_1_6?__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1MTS0IHQFP8ZN&keywords=Telefon&qid=1673873831&sprefix=telefon%2Caps%2C156&sr=8-6&th=1")) {
            System.out.println("Dogru Ürün");
        }
    }

    public void basketProduct() {

        methods.scrollWithAction(By.id("buy-now-button"));
        methods.waitBySeconds(1);

        methods.findElement(By.id("add-to-cart-button")).click();
        methods.waitBySeconds(3);
    }
    public void productComplete(){

        methods.findElement(By.cssSelector("span[class='a-button a-button-primary attach-primary-button attach-button-large attach-checkout-button']")).click();
        methods.waitBySeconds(3);

        methods.findElement(By.id("shipToThisAddressButton")).click();
        methods.waitBySeconds(4);

    }

    public void creditCard() throws InterruptedException {
        methods.findElement(By.cssSelector("a[class='a-link-emphasis pmts-add-cc-default-trigger-link']")).click();
        methods.waitBySeconds(3);

        methods.sendKeys(By.name("addCreditCardNumber]"),"5555 5555 5555 5555");
        methods.waitBySeconds(2);
        methods.sendKeys(By.cssSelector("input[class='a-input-text a-form-normal apx-add-credit-card-account-holder-name-input mcx-input-fields']"),"Talha Ertuğrul Çömez");
        methods.waitBySeconds(2);
        methods.findElement(By.cssSelector("span[class='a-button a-button-primary pmts-button-input']")).click();
        methods.waitBySeconds(1);

    }
}
