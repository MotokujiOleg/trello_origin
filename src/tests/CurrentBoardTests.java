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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;



public class CurrentBoardTests extends TestBase {


    @BeforeMethod
    public void initTests() throws InterruptedException {

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

        WebElement ourBoard = driver
                .findElement(By.xpath(boardLocator(BOARD_TITLE)));
        ourBoard.click();

        waitUntilElementIsClickable(By.xpath(boardLocator(BOARD_TITLE)),10);

    }


    @Test
    public void createNewList() throws InterruptedException {
        List<WebElement> listInDashBoardsBeforeAction = driver.findElements(By.xpath("//*[@class = 'js-list list-wrapper']"));
        int sizeBeforeAction = listInDashBoardsBeforeAction.size();
        System.out.println("Текущее количество листов: "+sizeBeforeAction);

        WebElement newListButtonKey = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        newListButtonKey.click();
        waitUntilElementIsClickable(By.xpath("//a[@class='open-add-list js-open-add-list']"),10);

        WebElement listButtonField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        listButtonField.sendKeys("Пятый список");
        waitUntilElementIsVisible(By.xpath("//input[@class='list-name-input']"), 5);

        WebElement submitNewListButtonKey = driver.findElement(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"));
        submitNewListButtonKey.click();
        waitUntilElementIsClickable(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"),10);

        List<WebElement> listInDashBoardsAfterAction = driver.findElements(By.xpath("//*[@class = 'js-list list-wrapper']"));
        int sizeAfterAction = listInDashBoardsAfterAction.size();
        System.out.println("Количество листов после добавления: " +sizeAfterAction);
        Assert.assertEquals(sizeAfterAction, sizeBeforeAction+1);

        System.out.println("Количество добавленных листов: " + (sizeAfterAction-sizeBeforeAction));



    }

    @Test
    public void createNewCard() throws InterruptedException {
        List<WebElement> listIsIn = driver.findElements(By.xpath("//*[@class='list-header-target js-editing-target']"));
        int listIsInSize = listIsIn.size();
        if (listIsInSize<=0){
            WebElement newListButtonKey = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
            newListButtonKey.click();
            waitUntilElementIsClickable(By.xpath("//a[@class='open-add-list js-open-add-list']"),10);

            WebElement listButtonField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
            listButtonField.sendKeys("Новый список");
            waitUntilElementIsVisible(By.xpath("//input[@class='list-name-input']"), 5);

            WebElement submitNewListButtonKey = driver.findElement(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"));
            submitNewListButtonKey.click();
            waitUntilElementIsClickable(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"),10);

            WebElement addACard = driver.findElement(By.xpath("//span[@class='js-add-a-card']"));
            addACard.click();
            waitUntilElementIsClickable(By.xpath("//span[@class='js-add-a-card']"),10);

            WebElement addAnotherCardField = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
            addAnotherCardField.sendKeys("Первая карточка");
            waitUntilElementIsVisible(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"), 5);

            WebElement submitAnotherCard = driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
            submitAnotherCard.click();
            waitUntilElementIsClickable(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"),10);

            driver.navigate().refresh();
        }


        List<WebElement> cardInBoardBeforeAction = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']"));
        int sizeBeforeAction = cardInBoardBeforeAction.size();
        System.out.println("Текущее количество карточек: "+sizeBeforeAction);

        WebElement addAnotherCard = driver.findElement(By.xpath("//span[@class='js-add-another-card']"));
        addAnotherCard.click();
        waitUntilElementIsClickable(By.xpath("//span[@class='js-add-another-card']"),10);

        WebElement addAnotherCardField = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
        addAnotherCardField.sendKeys("5th card");
        waitUntilElementIsVisible(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"), 5);

        WebElement submitAnotherCard = driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
        submitAnotherCard.click();
        waitUntilElementIsClickable(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"),10);

        driver.navigate().refresh();

        List<WebElement> cardInBoardAfterAction = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']"));
        int sizeAfterAction = cardInBoardAfterAction.size();
        System.out.println("Количество карточек после добавление: "+sizeAfterAction);
        Assert.assertEquals(sizeAfterAction, sizeBeforeAction+1);

        System.out.println("Количество добавленных карточек: " + (sizeAfterAction-sizeBeforeAction));





    }

    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }


}