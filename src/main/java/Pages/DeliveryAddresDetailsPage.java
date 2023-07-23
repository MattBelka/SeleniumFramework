package Pages;

import Base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DeliveryAddresDetailsPage  extends TestBase {

    GlobalMethods globalMethods;
    //Constructor
    public DeliveryAddresDetailsPage() {
         globalMethods= new GlobalMethods();
        PageFactory.initElements(driver,this);
    }


    //WebElements
    @FindBy(id = "shipping_first_name") private WebElement inputName;
    @FindBy(id = "shipping_last_name") private WebElement inputLastName;
    @FindBy(xpath = "//input[@class='select2-search__field']") private WebElement inputCountry;
    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    private WebElement arrowInputCountry;
    @FindBy(id = "shipping_address_1") private WebElement inputAddress;
    @FindBy(id = "shipping_postcode")private  WebElement inputPostCode;
    @FindBy(id = "shipping_city") private WebElement inputCity;
    @FindBy(name = "save_address")private  WebElement bntZapiszAdres;


    //Methods
    /*
    public void setDeliveryName(String deliveryName){
        wait.until(visibilityOf(inputName));
        inputName.clear();
        inputName.sendKeys(deliveryName);
    }


    public void setDeliveryLastName(String deliveryLastName) {
        wait.until(visibilityOf(inputLastName));
        inputLastName.clear();
        inputLastName.sendKeys(deliveryLastName);
    }
*/
    // Wpisanie wartości tekstowej w pole Region
/*
    public void setDeliveryAddress(String deliveryAddress){
        wait.until(visibilityOf(inputAddress));
        inputAddress.clear();
        inputAddress.sendKeys(deliveryAddress);
    }

    public void setDeliveryPostCode(String deliveryPostCode){
        wait.until(visibilityOf(inputAddress));
        inputPostCode.clear();
        inputPostCode.sendKeys(deliveryPostCode);
    }

    public void setDeliveryCity(String deliveryCity){
        wait.until(visibilityOf(inputCity));
        inputCity.clear();
        inputCity.sendKeys(deliveryCity);
    }

    public void clickBntZapiszAdres(){
        wait.until(elementToBeClickable(bntZapiszAdres));
        bntZapiszAdres.click();
    }
*/

    public void setCountry(String country){
        wait.until(visibilityOf(arrowInputCountry));
        arrowInputCountry.click();
        inputCountry.sendKeys(country, Keys.ENTER);
    }

    //Refactoring base on the new class GlobalMethods
    // Methods filling form of delivery address and returning Address Page

    public AddressPage fillForm(String deliveryName, String deliveryLastName,String country, String deliveryAddress,String deliveryPostCode,String deliveryCity) throws InterruptedException {

        globalMethods.setInput(inputName,deliveryName);
        globalMethods.setInput(inputLastName,deliveryLastName);
        setCountry(country);
        globalMethods.setInput(inputAddress,deliveryAddress);
        globalMethods.setInput(inputPostCode,deliveryPostCode);
        globalMethods.setInput(inputCity,deliveryCity);
        globalMethods.clickBnt(bntZapiszAdres);

        return new AddressPage();
    }

}
