import Base.TestBase;
import Pages.HomePage;
import Pages.ProductList;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductListPageTest extends TestBase {

    /******* objects declaration ********/
    HomePage homePage;
    ProductList productList;
    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
            ("PIŁKA NOŻNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PIŁKA NOŻNA ADIDAS REPLIKA LIGA MISTRZÓW",
                    "PIŁKA NOŻNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
                    "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));
    GlobalMethods globalMethods;

    /******* constructor ********/
    public ProductListPageTest(){
        super();
        globalMethods =new GlobalMethods();
    }

    //Before each method display browser with declared properties
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        productList =new ProductList();

        homePage.clickSklep();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    /******* tests ********/
    @Test(priority = 0)
    public void verifyAmmountOfProducts(){
        Assert.assertEquals(Integer.toString(productList.getNumberOfProducts()),testdata.getProperty("correctProductNumber"));
    globalMethods.takeScreenShot(1);
    }

    @Test(priority = 1)
    public void verifyListOfSortedProducts() throws InterruptedException {
        Assert.assertEquals(productList.getProductsNameAfterOrderByPrice(),correctProductListSortByPriceFromLowest);
    globalMethods.takeScreenShot(2);

    }
}
