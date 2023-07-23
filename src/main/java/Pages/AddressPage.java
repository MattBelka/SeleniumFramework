package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AddressPage extends TestBase {

    //Constructor
    public AddressPage(){
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath = "//div[@class='u-column2 col-2 woocommerce-Address']/address") WebElement adresDoWysylki;

    @FindBy(xpath = "//div[@class='u-column2 col-2 woocommerce-Address']/header/a[@class='edit']") WebElement btnEditAdressDoWysylki;

    //Methods
    public String getAdressDoWysylki(){
        wait.until(visibilityOf(adresDoWysylki));
        String adresDoWysylkiText = adresDoWysylki.getText();
        System.out.println("komunikat adres dostawy: " + adresDoWysylkiText);
        return adresDoWysylkiText;
    }

    public DeliveryAddresDetailsPage clickBtnEditAddress(){
        wait.until(visibilityOf(btnEditAdressDoWysylki));
        btnEditAdressDoWysylki.click();
        return new DeliveryAddresDetailsPage();
    }

}
