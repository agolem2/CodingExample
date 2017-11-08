package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KayakCarDropOffSearchBox {

    public static WebElement element = null;

    public static WebElement SearchBox(WebDriver driver)

    {
        element = driver.findElement(By.name("dropoff"));

        return element;

    }
}