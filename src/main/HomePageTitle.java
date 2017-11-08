package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// HomePage Title Link

public class HomePageTitle {

	public static WebElement element = null;
     
    public static WebElement HomePageTitleText (WebDriver driver)
   
    {element = driver.findElement(By.cssSelector("section.title-section > div > h2"));
    
    return element;

    }

}