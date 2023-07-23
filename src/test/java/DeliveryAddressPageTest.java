import Pages.*;
import Base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.TestBase.driver;
import static Base.TestBase.initialization;

public class DeliveryAddressPageTest extends TestBase{

    /******* objects declaration ********/
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddresDetailsPage deliveryAddresDetailsPage;
    GlobalMethods globalMethods;

    /******* constructor ********/
    public DeliveryAddressPageTest(){
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
        deliveryAddresDetailsPage = addressPage.clickBtnEditAddress();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    /******* tests ********/
   @Test(priority = 0)
    public void editDeliveryAddress() throws InterruptedException {
        deliveryAddresDetailsPage.fillForm("Matt","Bee","Polska",
                "Kopernika", "00-001", "Wrocław");
       Assert.assertEquals(addressPage.getAdressDoWysylki(),
               "Matt Bee\n"+
               "Kopernika\n" +
               "00-001 Wrocław");
       globalMethods.takeScreenShot(1);
   }

}
