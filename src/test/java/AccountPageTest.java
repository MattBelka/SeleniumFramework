import Base.TestBase;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends TestBase {
    /******* objects declaration ********/
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    GlobalMethods globalMethods;

    /******* constructor ********/
    public AccountPageTest(){
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
    //After test close the browser
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    /******* tests ********/
    @Test (priority = 0)
    public void verifyUser(){
        Assert.assertEquals(accountPage.getNameAccount(),testdata.getProperty("correctNameAccount"));
        globalMethods.takeScreenShot(1);
    }
}

