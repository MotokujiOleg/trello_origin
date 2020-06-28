package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardsPageHelper extends PageBase {
    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageisLoaged() {
        String textDashboardButton = driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText();
        waitUntilElementIsClickable(By.xpath("//span[@class = 'MEu8ZECLGMLeab']"), 10);
    }

    public String getButtonBoardsText() {
        return driver.findElement(By.xpath("//span[@class = 'MEu8ZECLGMLeab']")).getText();
    }
}
