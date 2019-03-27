import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LogInPage logInPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\Tools\\WebDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com/login");
        logInPage = new LogInPage(driver);
    }

    @Test
    public void logInWithEmptyCredsTest(){
        //При возврате той же самой страницы с чего и начинали
        //Создаем новый объект LoginPage
        LogInPage newLoginPage = logInPage.userLoginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void logInWithIncorrectCredsTest(){
        LogInPage newLogInPage = logInPage.userLoginWithInvalidCreds("trtrt","jhfbksfdkjvn");
        String error = newLogInPage.getErrorText();
        assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void clickCreateAccountLinkTest(){
        SignUpPage signUpPage = logInPage.createAccount();
        String heading = signUpPage.getHeadingText();
        assertEquals("Join GitHub", heading);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
