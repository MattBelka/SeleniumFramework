import Base.TestBase;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderConfirmedPage;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderConfirmedPageTest extends TestBase {
    /******* objects declaration ********/
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;
    GlobalMethods globalMethods;

    /******* constructor ********/
    public OrderConfirmedPageTest(){
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
        orderConfirmedPage =new OrderConfirmedPage();
        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("user" + "Password"));
        accountPage.clickTabZamowienia();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    /******* tests ********/
    @Test(priority = 0)
    public void verifyIfOrdersExists(){
        String infoAboutTheOrders = orderConfirmedPage.getInfoAboutOrders();
        Assert.assertEquals(infoAboutTheOrders,testdata.getProperty("correctInfoAboutOrder"));
    globalMethods.takeScreenShot(1);
    }

}


