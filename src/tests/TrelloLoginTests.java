package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;



public class TrelloLoginTests extends TestBase {




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

        String textDashboardButton = driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText();

        System.out.println("Text Dashboard button: " + textDashboardButton);
        Thread.sleep(5000);
        Assert.assertEquals("Boards", textDashboardButton);
    }

    @Test
    public void workWithApplNegativeEmail() throws InterruptedException{

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys("dsadadadasdas@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys(PASSWORD);
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='error']//*[@class = 'error-message']")).getText();

        System.out.println("Error text board: " + errorTestBoard);
        Thread.sleep(5000);
        Assert.assertEquals("Аккаунт с таким адресом электронной почты не существует", errorTestBoard);

    }

    @Test
    public void workWithApplNegativePassword() throws InterruptedException{

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys(LOGIN);
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys("!@#$!$@!@#!");
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='password-error']//*[@class = 'error-message']")).getText();

        System.out.println("Error text board: " + errorTestBoard);
        Thread.sleep(5000);
        Assert.assertEquals("Указан неправильный адрес и/или пароль. Вам нужна помощь со входом?", errorTestBoard);

    }


}