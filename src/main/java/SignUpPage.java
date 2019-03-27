
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerH1 = By.xpath("//div[contains(@class, 'setup-header')]/h1");
    private By userNameField = By.xpath("//input[@name='user[login]']");
    private By userEmailField = By.xpath("//input[@name='user[email]']");
    private By userPasswordField = By.xpath("//input[@name='user[password]']");
    private By createAccountButton = By.xpath("//button[@id='signup_button']");
    private By errorFlashMain = By.xpath("//input[@name='user[login]']/ancestor::auto-check/preceding-sibling::div[contains(@class, 'flash-error')]");
    private By errorFlashUserName = By.xpath("//input[@name='user[login]']/ancestor::dd/following-sibling::dd[@class='error']");
    private By errorFlashUserEmail  = By.xpath("//input[@name='user[email]']/ancestor::dd/following-sibling::dd[@class='error']");
    private By errorFlashUserPassword = By.xpath("//input[@name='user[password]']/ancestor::dd/following-sibling::dd[@class='error']");


    public SignUpPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage typeUserEmail(String userEmail) {
        driver.findElement(userEmailField).sendKeys(userEmail);
        return this;
    }

    public SignUpPage typeUserPassword(String userPassword) {
        driver.findElement(userPasswordField).sendKeys(userPassword);
        return this;
    }

    public SignUpPage userRegisterWithInvalidCreds(String userName, String userEmail, String userPassword) {
        this.typeUserName(userName);
        this.typeUserEmail(userEmail);
        this.typeUserPassword(userPassword);

//		WebElement createAccountButtonElement = driver.findElement(createAccountButtonXPath);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(createAccountButton));
        driver.findElement(createAccountButton).submit();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(headerH1).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(errorFlashMain).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(errorFlashUserName).getText();
    }

    public String getUserEmailErrorText() {
        return driver.findElement(errorFlashUserEmail).getText();
    }

    public String getUserPasswordErrorText() {
        return driver.findElement(errorFlashUserPassword).getText();
    }


}
