package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloProfileTests extends TestBase {

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

    }

    @Test
    public void initialsTest() throws InterruptedException {
        WebElement openMemberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        openMemberMenu.click();
        waitUntilElementIsClickable(By.xpath("//button[@aria-label='Open Member Menu']"),10);

        WebElement openProfileAndVisibilityMenu = driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']"));
        openProfileAndVisibilityMenu.click();
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id='header-member-menu-profile']"),10);

        WebElement centralInitialsProfileIcon = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu' and @data-test-id='header-member-menu-button']//div[@title='Oleg Manpel (olegmanpel)']//span[text()='OM']"));

        Assert.assertEquals(openMemberMenu.getText(), centralInitialsProfileIcon.getText(), "Initials is not Equals");

    }

    @Test
    public void userNameEquals() throws InterruptedException {
        WebElement openMemberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        openMemberMenu.click();
        waitUntilElementIsClickable(By.xpath("//button[@aria-label='Open Member Menu']"),10);

        WebElement openProfileAndVisibilityMenu = driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']"));
        openProfileAndVisibilityMenu.click();
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id='header-member-menu-profile']"),10);

        String upperUserName = driver.findElement(By.xpath("//span[@class='YGN7y_VVuqFYYB']")).getText();
        System.out.println(upperUserName + " The Upper User Name");

        WebElement bottomUserName = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println(bottomUserName.getAttribute("value") + " The Bottom User Name");

        Assert.assertEquals("@"+bottomUserName.getAttribute("value"), upperUserName, "Usernames is not okay");

    }


    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }

}
