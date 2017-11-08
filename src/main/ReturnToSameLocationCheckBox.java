package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnToSameLocationCheckBox {

    public static WebElement element = null;

    public static WebElement ReturnToSameLocation(WebDriver driver)

    {
        element = driver.findElement(By.xpath("//*[@id='oneWayField-icon']"));

        return element;

    }
}