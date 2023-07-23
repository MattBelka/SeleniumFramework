import Base.TestBase;
import Pages.AccountPage;
import Pages.AddressPage;
import Pages.HomePage;
import Pages.LoginPage;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressPageTest extends TestBase {
    /******* objects declaration ********/
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    GlobalMethods globalMethods;
    AddressPage addressPage;


    /******* constructor ********/
    public AddressPageTest(){
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
        addressPage =new AddressPage();
        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        accountPage.clickTabAddress();
    }

    @AfterTest
    public void closeBrowser(){
    driver.quit();
    }

    /******* tests ********/
    @Test(priority = 0)
    public void verifyAddress(){
        Assert.assertEquals(addressPage.getAdressDoWysylki(),testdata.getProperty("correctInfoAboutDeliveryAddress"), "Adres jest ustawiony");
        globalMethods.takeScreenShot(1);
    }

}
