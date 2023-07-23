package Pages;

import helpers.GlobalMethods;
import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends TestBase {

    GlobalMethods globalMethods;
    //Constructor and WebElements initialization
    public LoginPage(){
        globalMethods = new GlobalMethods();
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy (id = "username") WebElement inputLogin;
    @FindBy (id ="password") WebElement inputPassowrd;
    @FindBy (xpath = "//button[@value='Zaloguj się']") WebElement bntZaloguj;


    //Methods
    public String getPageTitle(){
       return globalMethods.getPageTitle();
   }

    public void insertLogin(String userName){
        wait.until(visibilityOf(inputLogin));
        inputLogin.clear();
        inputLogin.sendKeys(userName);
    }
    public void insertPassword(String userPassword){
        wait.until(visibilityOf(inputPassowrd));
        inputPassowrd.clear();
        inputPassowrd.sendKeys(userPassword);
    }
    public void clickBntZaloguj(){
        wait.until(elementToBeClickable(bntZaloguj));
        bntZaloguj.click();

    }

    //Login process and return legged in Account page
    public AccountPage login(String userName, String userPassword) {
        insertLogin(userName);
        insertPassword(userPassword);
        clickBntZaloguj();
        return new AccountPage();
    }
}
