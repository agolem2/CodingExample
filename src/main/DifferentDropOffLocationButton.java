package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DifferentDropOffLocationButton {

    public static WebElement element = null;

    public static WebElement DropOffLocationButton(WebDriver driver) {
        {
            element = driver.findElement(By.xpath("//*[@title='Different Drop-off']/span"));

            return element;

        }
    }
}