package Amazon.test;

import Amazon.driver.BaseTest;
import Amazon.page.LoginPage;
import Amazon.page.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.page();
        loginPage.userlogin();
        productPage.searchProduct();
        productPage.selectedProduct();
        productPage.basketProduct();
        productPage.productComplete();
        productPage.creditCard();

    }
}