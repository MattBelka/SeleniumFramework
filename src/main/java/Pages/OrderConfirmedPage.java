package Pages;
import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;



public class OrderConfirmedPage extends TestBase {


    //Constructor
    public OrderConfirmedPage() {
        PageFactory.initElements(driver, this);
    }

    //WebElements
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/div[2]")
    WebElement infoAboutOrders;

    //Methods
    public String getInfoAboutOrders() {
        wait.until(visibilityOf(infoAboutOrders));
        String message = infoAboutOrders.getText();
        System.out.println("Komunikat dotyczący ilośc złożonych zamówień: " + message);
        return message;
    }
}