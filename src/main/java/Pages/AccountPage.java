package Pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {

    //Constructor
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    WebElement nameAccountLabel;

    @FindBy(xpath = "//li[contains(@class,'edit-address')]") WebElement tabAddress;

    @FindBy(xpath = "//a[text()='Zamówienia']") WebElement tabZamowienia;


    //Methods
    //Get account name and return
    public String getNameAccount(){
        wait.until(visibilityOf(nameAccountLabel));
        String nameAccount = nameAccountLabel.getText();
        System.out.println("Nazwa konta " + nameAccount);
        return nameAccount;

    }
    // Move to the Address Page
    public AddressPage clickTabAddress(){
        wait.until(visibilityOf(tabAddress));
        tabAddress.click();
        return new AddressPage();
    }

    // Move to the tab Orders (confirmation orders)
    public OrderConfirmedPage clickTabZamowienia(){
        wait.until(visibilityOf(tabZamowienia));
        tabZamowienia.click();
        return new OrderConfirmedPage();

    }



}
