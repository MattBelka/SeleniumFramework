package Pages;

import Base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class HomePage extends TestBase{


    //Constructor
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy (linkText = "MOJE KONTO") private WebElement myAccountMenu;
    @FindBy (linkText = "SKLEP") private WebElement shopMenu;

    //Methods
    //Move to My account page and return Login page
    public LoginPage goToLoginPage(){
        wait.until(visibilityOf(myAccountMenu));
        myAccountMenu.click();
        return new LoginPage();
    }

    //Return product list
   public ProductList clickSklep(){
        wait.until(visibilityOf(shopMenu));
        shopMenu.click();
        return new ProductList();
    }
}
