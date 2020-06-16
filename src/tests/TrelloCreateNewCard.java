package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TrelloCreateNewCard extends TestBase {

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
    public void createNewCard() throws InterruptedException {
        List<WebElement> listIsIn = driver.findElements(By.xpath("//*[@class='list-header-target js-editing-target']"));
        int listIsInSize = listIsIn.size();
        if (listIsInSize<=0){
            WebElement newListButtonKey = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
            newListButtonKey.click();
            Thread.sleep(2000);

            WebElement listButtonField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
            listButtonField.sendKeys("Новый список");
            Thread.sleep(2000);

            WebElement submitNewListButtonKey = driver.findElement(By.xpath("//input[@class ='primary mod-list-add-button js-save-edit']"));
            submitNewListButtonKey.click();
            Thread.sleep(2000);

//            driver.navigate().refresh();
//            Thread.sleep(4000);

            WebElement addACard = driver.findElement(By.xpath("//span[@class='js-add-a-card']"));
            addACard.click();
            Thread.sleep(2000);

            WebElement addAnotherCardField = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
            addAnotherCardField.sendKeys("Первая карточка");
            Thread.sleep(2000);

            WebElement submitAnotherCard = driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
            submitAnotherCard.click();
            Thread.sleep(2000);

            driver.navigate().refresh();
            Thread.sleep(4000);
        }


        List<WebElement> cardInBoardBeforeAction = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']"));
        int sizeBeforeAction = cardInBoardBeforeAction.size();
        System.out.println("Текущее количество карточек: "+sizeBeforeAction);
        Thread.sleep(2000);

        WebElement addAnotherCard = driver.findElement(By.xpath("//span[@class='js-add-another-card']"));
        addAnotherCard.click();
        Thread.sleep(2000);

        WebElement addAnotherCardField = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
        addAnotherCardField.sendKeys("5th card");
        Thread.sleep(2000);

        WebElement submitAnotherCard = driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
        submitAnotherCard.click();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(4000);

        List<WebElement> cardInBoardAfterAction = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']"));
        int sizeAfterAction = cardInBoardAfterAction.size();
        System.out.println("Количество карточек после добавление: "+sizeAfterAction);
        Thread.sleep(2000);

        System.out.println("Количество добавленных карточек: " + (sizeAfterAction-sizeBeforeAction));

    }

    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }


}
