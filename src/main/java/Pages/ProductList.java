package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.ArrayList;
import java.util.List;


public class ProductList extends TestBase {

    //Constructor
    public ProductList() {
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy (xpath = "//ul[contains(@class,'products')]/li")
    List <WebElement> listOfProducts;

    @FindBy(xpath = "//ul[contains(@class,'products')]/li/a/h2")
    List<WebElement> productsName;

    @FindBy(name = "orderby")
    WebElement orderbyList;


    //Methods
    public int getNumberOfProducts(){
        wait.until(visibilityOfAllElements(listOfProducts));
        int productsNumber = listOfProducts.size();
        return productsNumber;
    }


    // Select from the sorting list by price: from lower to higher
    public void sortProductByPrice(){
        Select orderByList = new Select(orderbyList);
        orderByList.selectByValue("price");
    }

    //Get sorted products and write names to the console
    public ArrayList getProductsNameAfterOrderByPrice() throws InterruptedException {
        sortProductByPrice();
        Thread.sleep(2000);
        ArrayList productsNameList = new ArrayList();
        for (int i = 0; i < listOfProducts.size(); i++) {
            productsNameList.add(productsName.get(i).getText());
            System.out.println(productsNameList.get(i));
        }
        return productsNameList;
    }




}
