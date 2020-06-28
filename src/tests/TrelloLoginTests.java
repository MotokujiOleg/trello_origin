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
import pages.BoardsPageHelper;
import pages.LoginPageHelper;
import tests.TestBase;



public class TrelloLoginTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
    }




    @Test

    public void workWithApplPositive() throws InterruptedException{

        loginPage.openLoginPage();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickNextButton();

        String textDashboardButton = driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText();

        System.out.println("Text Dashboard button: " + textDashboardButton);
        Assert.assertEquals("Boards", boardsPage.getButtonBoardsText());
    }

    @Test
    public void workWithApplNegativeEmail() throws InterruptedException{

        loginPage.openLoginPage();
        loginPage.enterLogin("somenegativemail@gmail.com");
        loginPage.enterPassword(PASSWORD);
        loginPage.clickNextButton();

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='error']//*[@class = 'error-message']")).getText();

        System.out.println("Error text board: " + errorTestBoard);
        Assert.assertEquals("Аккаунт с таким адресом электронной почты не существует", errorTestBoard);

    }



    @Test
    public void workWithApplNegativePassword() throws InterruptedException{

        loginPage.openLoginPage();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword("somewrongpassword");
        loginPage.clickNextButton();

        String errorTestBoard = driver.findElement(By.xpath("//*[@id='password-error']//*[@class = 'error-message']")).getText();

        System.out.println("Error text board: " + errorTestBoard);
        Assert.assertEquals("Указан неправильный адрес и/или пароль. Вам нужна помощь со входом?", errorTestBoard);

    }



}