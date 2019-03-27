import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",  "c:\\Tools\\WebDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LogInPage logInPage = mainPage.clickSignIn();
        String heading = logInPage.getHeadingText();
        assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.userRegister("testuser","fdnlsdfn555", "jfdjd@mail.zum");
        String error = signUpPage.getMainErrorText();
        assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.userRegister("", "jnfjnsdfjnjs", "jndfjn@mail.coz");
        String error = signUpPage.getUserNameErrorText();
        assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.userRegister("testuser", "fdgsdf","nfnfn@");
        String error = signUpPage.getUserEmailErrorText();
        assertEquals("Email is invalid or already taken", error);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
