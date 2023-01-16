package Amazon.test;

import Amazon.driver.BaseTest;
import Amazon.page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage LoginPage = new LoginPage();
        LoginPage.page();
        LoginPage.userlogin();
    }
}