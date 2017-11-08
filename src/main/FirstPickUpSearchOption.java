package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPickUpSearchOption {

    public static WebElement element = null;

    public static WebElement SelectFirstOption (WebDriver driver)

    {
        element = driver.findElement(By.xpath("//b[3]"));

        return element;

    }
}
