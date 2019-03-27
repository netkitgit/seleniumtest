import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='login']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//input[@name='commit']");
    private By formHeaderH1  = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By errorFlash = By.xpath("//div[contains(@class,'flash-error')]/div[@class='container']");
    private By createAccountLink = By.xpath("//a[text()='Create an account']");

    public LogInPage typeUserName(String userName) {
        driver.findElement(loginField).sendKeys(userName);
        return this;
    }

    public LogInPage typeUserPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }

//	public SignUpPage clickSignInButton() {
//		driver.findElement(signInButton).submit();
//		return new SignUpPage(driver);
//	}

    public String getHeadingText() {
        return driver.findElement(formHeaderH1).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorFlash).getText();
    }

    public LogInPage userLoginWithInvalidCreds(String userName, String userPassword) {
        this.typeUserName(userName);
        this.typeUserPassword(userPassword);
        driver.findElement(signInButton).submit();
        return new LogInPage(driver);
    }

//	public SignUpPage userLogin(String userName, String userPassword) {
//		this.typeUserName(userName);
//		this.typeUserPassword(userPassword);
//		driver.findElement(signInButton).submit();
//		return new SignUpPage(driver);
//	}

    public SignUpPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }


}