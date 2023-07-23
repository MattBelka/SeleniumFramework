package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

//TestBase class is used to be a base for the extension for project classes. It's assigning property files and initial method.
public class  TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;


    // method TestBase assigns property files to the TestBase class.
    public TestBase(){

        //configuration of URL, browser, page load timeout, cookies delete and maximize browser window.
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Test data file contains data used during testng (User, Password other fields to be filed, correct static expected results).
        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setting initial properties of the browser, type of the browser Chrome/Firefox
    public static void initialization(){

        System.setProperty("file.encoding", "UTF-8");
        String url = config.getProperty("URL");
        String browser = config.getProperty("browser");
        String pageLoadTimeout = config.getProperty("pageLoadTimeout");
        String windowsMaximize = config.getProperty("windowsMaximize");
        String deleteAllCookies = config.getProperty("deleteAllCookies");
        String waitTimeout = config.getProperty("waitTimeout");

        //Browser case depends on config.properties
        switch (browser) {
            case "chrome" -> {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                        "/src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito"); // Enable incognito mode
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                        "/src/main/resources/geckodriver.exe");
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                driver = new FirefoxDriver(optionsFirefox);
            }
            default -> throw new IllegalArgumentException("Nierozpoznano typu przeglądarki internetowej." +
                    "Obsługiwane następujące opcje: chrome, firefox");
        }
        //Removes cookies
        if(deleteAllCookies.equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        //Maximize browser window
        if(windowsMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }
        //Sets max wait timeout of page loading
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(pageLoadTimeout)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(waitTimeout)));

        driver.get(url);

    }
    public void waitForThePage() throws InterruptedException {
        Thread.sleep(3000);
    }


}
