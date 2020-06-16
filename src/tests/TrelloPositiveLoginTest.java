package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TrelloPositiveLoginTest extends TestBase {

    @Test

    public void workWithApplPositive() throws InterruptedException{


        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys(LOGIN);
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys(PASSWORD);
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        System.out.println("Text Dashboard button: " + driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText());
        Thread.sleep(5000);
    }
}
