import Base.TestBase;
import Pages.*;

import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPageTest extends TestBase {

    /******* objects declaration ********/
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    GlobalMethods globalMethods;


    /******* constructor ********/
    public LoginPageTest(){
        super();
        globalMethods = new GlobalMethods();
    }

    //Before each method display browser with declared properties
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }


    /******* tests ********/
    @Test (priority = 0)
    public void verifyPageTitle(){

        String expectedTitile = loginPage.getPageTitle();
        String actualTitle = testdata.getProperty("correctAccountPageTitle");
        boolean testTitile = expectedTitile.replace("–","-").equals(actualTitle);
        Assert.assertTrue(testTitile);
        globalMethods.takeScreenShot(1);


    }


}
