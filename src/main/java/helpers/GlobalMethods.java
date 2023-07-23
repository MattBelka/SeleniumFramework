package helpers;
import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

//Class GlobalMethods is collecting often used functions in the project.
public class GlobalMethods extends TestBase {

    public GlobalMethods(){}

    //Method returns page title
    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("Title :" +title);
        return title;
    }

    //Method clears the input field and sends text
    public void setInput(WebElement inputElement,String text){
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    //Method performing click button action. Is waiting till element is visible.
    public void clickBnt(WebElement btnElement){
        wait.until(elementToBeClickable(btnElement));
        btnElement.click();
    }
    //When implemented is taking screenshot of the current page and saving in the indicated directory.
    public void takeScreenShot(int TestId){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        try {
            FileUtils.copyFile(src, new File("src/main/resources/screenShots/" +className+ "_"+ TestId + "_screenshot.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
