package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KayakCarSearchButton {

    public static WebElement element = null;

    public static WebElement SubmitSearchButton(WebDriver driver)

    {
        element = driver.findElement(By.xpath("//div[2]/form/div/div[2]/div/button"));

        return element;

    }
}