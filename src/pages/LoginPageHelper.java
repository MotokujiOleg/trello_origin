package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        waitUntilElementIsClickable(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"), 10);
    }

    public void enterLogin(String login) {
        WebElement loginInputField = driver.findElement(By.id("user"));
        loginInputField.sendKeys(login);
        waitUntilElementIsVisible(By.id("user"), 5);

    }

    public void enterPassword(String password) {
        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys(password);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'password']"), 5);
    }

    public void clickNextButton() {
        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        waitUntilElementIsClickable(By.xpath("//input[@id = 'login']"), 10);
    }


}
