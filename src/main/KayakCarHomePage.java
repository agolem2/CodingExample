package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverBrowserFactory;

public class KayakCarHomePage extends WebDriverBrowserFactory {

	
	// Coding Challenge Kayak Cars Homepage 

    public static final By HomePageURl = null;

	public static String HomePageURl(WebDriver driver)

    {

        String KyakCarsHomepage = ("https://www.kayak.com/cars");

        return KyakCarsHomepage;

    }

  
}