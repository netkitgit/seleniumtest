import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\Tools\\WebDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void correctHeadingTest(){
        String heading = signUpPage.getHeadingText();
        assertEquals("Join GitHub", heading);
    }



    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
