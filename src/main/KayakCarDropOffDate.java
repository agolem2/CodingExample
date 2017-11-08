package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KayakCarDropOffDate {

    public static WebElement element = null;

    public static WebElement DropOffDate(WebDriver driver)

    {
        element = driver.findElement(By.xpath(".//*[@aria-label='Drop-off date']"));

        return element;

    }
}