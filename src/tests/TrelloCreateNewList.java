package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TrelloCreateNewList extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {

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

        WebElement ourBoard = driver
                .findElement(By.xpath(boardLocator(BOARD_TITLE)));
        ourBoard.click();
        Thread.sleep(5000);

    }


    @Test
    public void createNewList() throws InterruptedException {
        List<WebElement> listInDashBoardsBeforeAction = driver.findElements(By.xpath("//*[@class = 'js-list list-wrapper']"));
        int sizeBeforeAction = listInDashBoardsBeforeAction.size();
        System.out.println("Текущее количество листов: "+sizeBeforeAction);
        Thread.sleep(2000);

        WebElement newListButtonKey = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        newListButtonKey.click();
        Thread.sleep(2000);

        WebElement listButtonField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        listButtonField.sendKeys("Пятый список");
        Thread.sleep(2000);

        WebElement submitNewListButtonKey = driver.findElement(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"));
        submitNewListButtonKey.click();
        Thread.sleep(2000);

        List<WebElement> listInDashBoardsAfterAction = driver.findElements(By.xpath("//*[@class = 'js-list list-wrapper']"));
        int sizeAfterAction = listInDashBoardsAfterAction.size();
        System.out.println("Количество листов после добавления: " +sizeAfterAction);
        Thread.sleep(2000);

        System.out.println("Количество добавленных листов: " + (sizeAfterAction-sizeBeforeAction));
        Assert.assertEquals(sizeAfterAction,sizeBeforeAction+1,"Ожидания не оправдались :-(" );


    }
    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }
}
