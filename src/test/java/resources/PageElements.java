package resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    private By txtUsername = By.xpath("//input[@name='username']");
    private By txtPassword = By.xpath("//input[@name='password']");
    private By btnLogin = By.xpath("//button[@type='submit']");
    private By lblAccountName = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By elementAdminPage = By.xpath("//span[text()='Admin']");

    public PageElements(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        loginButton.click();
    }
    
    public String getTitleHRM() {
        return driver.getTitle();
    }

    public String getAccountName() {
        WebElement accountNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountName));
        return accountNameLabel.getText();
    }
    
    public void navToAdminButton() {
    	WebElement accountNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(elementAdminPage));
    	accountNameLabel.click();
    }
    
    public String verifyAdminPage() {
    	return driver.getCurrentUrl();
    }
    
}

