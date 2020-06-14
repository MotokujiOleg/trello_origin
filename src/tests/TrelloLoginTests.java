package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TrelloLoginTests {

    public WebDriver driver;

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://www.trello.com/");
        Thread.sleep(5000);

    }
    @Test

    public void workWithApplPositive() throws InterruptedException{


        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys("manpelolegff471@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys("Oleg1304");
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        System.out.println("Text Dashboard button: " + driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText());
        Thread.sleep(5000);
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
        passwordInputField.sendKeys("Oleg1304");
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        System.out.println("Error text board: " + driver.findElement(By.xpath("//*[@id='error']//*[@class = 'error-message']")).getText());
        Thread.sleep(5000);

    }

    @Test
    public void workWithApplNegativePassword() throws InterruptedException{

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement loginInputField = driver.findElement(By.xpath("//input[@id = 'user']"));
        loginInputField.sendKeys("manpelolegff471@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordInputField.sendKeys("!@#$!$@!@#!");
        Thread.sleep(1000);

        WebElement loginButtonNext = driver.findElement(By.xpath("//input[@id = 'login']"));
        loginButtonNext.click();
        Thread.sleep(3000);

        System.out.println("Error text board: " + driver.findElement(By.xpath("//*[@id='password-error']//*[@class = 'error-message']")).getText());
        Thread.sleep(5000);

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}