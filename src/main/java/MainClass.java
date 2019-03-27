
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",  "c:\\Tools\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
//		MainPage_PageFactory mainPage = PageFactory.initElements(driver, MainPage_PageFactory.class);

        mainPage.userRegister("testuser", "testpass645454", "test@test.org");

    }

}