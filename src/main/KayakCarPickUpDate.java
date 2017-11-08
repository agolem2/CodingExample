package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KayakCarPickUpDate {

    public static WebElement element = null;

    public static WebElement PickUpDate(WebDriver driver)

    {
        element = driver.findElement(By.xpath(".//*[@aria-label='Pick-up date']"));
      
        return element;

    }

	public static WebElement PickUpDate() {
		// TODO Auto-generated method stub
		return null;
	}
}