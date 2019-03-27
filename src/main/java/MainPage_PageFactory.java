
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage_PageFactory {
    private WebDriver driver;

    public MainPage_PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    //описываем локаторы элементов с котороми будем работать на странице
    //в боевом проекте описываются все локаторы всех элементов для покрытия тестами
    @FindBy(xpath="//a[contains(@data-ga-click, 'Sign in') and contains(@class, 'HeaderMenu-link')]")
    private WebElement signInButton;
    @FindBy(xpath="//a[contains(@data-ga-click, 'Sign up') and contains(@class, 'HeaderMenu-link')]")
    private WebElement signUpButton;
    @FindBy(xpath="//input[@name='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath="//input[@name='user[email]']")
    private WebElement emailField;
    @FindBy(xpath="//input[@name='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath="//button[text()='Sign up for GitHub']")
    private WebElement signUpFormButton;

    //описываем методы для работы с элементами

    public LogInPage clickSignIn() {
        signInButton.click();
        return new LogInPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage_PageFactory typeUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public MainPage_PageFactory typeUserPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
        return this;
    }

    public MainPage_PageFactory typeUserEmail(String userEmail) {
        emailField.sendKeys(userEmail);
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
