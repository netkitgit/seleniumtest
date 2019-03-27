import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //описываем локаторы элементов с котороми будем работать на странице
    //в боевом проекте описываются все локаторы всех элементов для покрытия тестами
    private By signInButton = By.xpath("//a[contains(@data-ga-click, 'Sign in') and contains(@class, 'HeaderMenu-link')]");
    private By signUpButton = By.xpath("//a[contains(@data-ga-click, 'Sign up') and contains(@class, 'HeaderMenu-link')]");
    private By userNameField = By.xpath("//input[@name='user[login]']");
    private By emailField = By.xpath("//input[@name='user[email]']");
    private By passwordField = By.xpath("//input[@name='user[password]']");
    private By signUpFormButton = By.xpath("//button[text()='Sign up for GitHub']");

    //описываем методы для работы с элементами

    public LogInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LogInPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public MainPage typeUserPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }

    public MainPage typeUserEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }

    public SignUpPage userRegister(String userName, String userPassword, String userEmail) {
        this.typeUserName(userName);
        this.typeUserEmail(userEmail);
        this.typeUserPassword(userPassword);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

}
