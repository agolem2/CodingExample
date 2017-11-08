package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstDropOffLocation {

    public static WebElement element = null;

    public static WebElement SelectFirstOption (WebDriver driver)

    {
        element = driver.findElement(By.cssSelector("//b[2]"));

        return element;

    }
}

