package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        waitUntilElementIsClickable(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"), 10);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys(LOGIN);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'user']"), 5);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys(PASSWORD);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'password']"), 5);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        waitUntilElementIsClickable(By.xpath("//input[@id = 'login']"),10);

        String textDashboardButton = driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText();

        System.out.println("Text Dashboard button: " + textDashboardButton);
        Assert.assertEquals("Boards", textDashboardButton);
    }

    @Test
    public void workWithApplNegativeEmail() throws InterruptedException{

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        waitUntilElementIsClickable(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"), 10);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys("dsadadadasdas@gmail.com");
        waitUntilElementIsVisible(By.xpath("//input[@id = 'user']"), 5);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys(PASSWORD);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'password']"), 5);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        waitUntilElementIsClickable(By.xpath("//input[@id = 'login']"),10);

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='error']//*[@class = 'error-message']")).getText();

        System.out.println("Error text board: " + errorTestBoard);
        Assert.assertEquals("Аккаунт с таким адресом электронной почты не существует", errorTestBoard);

    }



    @Test
    public void workWithApplNegativePassword() throws InterruptedException{

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        waitUntilElementIsClickable(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"), 10);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys(LOGIN);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'user']"), 5);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys("!@#$!$@!@#!");
        waitUntilElementIsVisible(By.xpath("//input[@id = 'password']"), 5);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        waitUntilElementIsClickable(By.xpath("//input[@id = 'login']"), 10);
        waitUntilElementIsVisible(By.xpath("//input[@id = 'login']"), 10);

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='password-error']//*[@class = 'error-message']")).getText();


        System.out.println("Error text board: " + errorTestBoard);
        Assert.assertEquals("Указан неправильный адрес и/или пароль. Вам нужна помощь со входом?", errorTestBoard);

    }



}