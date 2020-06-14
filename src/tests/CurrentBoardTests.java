package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //---- Enter to the application ---
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(5000);
    }

    @Test
    public void createNewList() throws InterruptedException {
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

        WebElement boardQAHaifa56 = driver.findElement(By.xpath("//*[@title='QAHaifa56' and @class ='board-tile-details-name']"));
        boardQAHaifa56.click();
        Thread.sleep(3000);

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



    }

    @Test
    public void createNewCard() throws InterruptedException {
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

        WebElement boardQAHaifa56 = driver.findElement(By.xpath("//*[@title='QAHaifa56' and @class ='board-tile-details-name']"));
        boardQAHaifa56.click();
        Thread.sleep(3000);

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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}