package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.DifferentDropOffLocationButton;
import main.FirstPickUpSearchOption;
import main.HomePageTitle;
import main.KayakCarDropOffDate;
import main.KayakCarDropOffSearchBox;
import main.KayakCarHomePage;
import main.KayakCarPickUpDate;
import main.KayakCarPickUpSearchBox;
import main.KayakCarSearchButton;
import util.ScreenShotOnFailure;
import util.WebDriverBrowserFactory;


public class TwoDayLocationCarRentalCompairsonTest extends WebDriverBrowserFactory {

    public static Logger Log = Logger.getLogger(Logger.class.getName());
    public static StringBuffer verificationErrors = new StringBuffer();

    static java.util.Date date = new java.util.Date();
    static Timestamp t = new Timestamp(date.getTime());
    static String dateNow = t.toString().replace(":", "_");

    @Rule
    public ScreenShotOnFailure screenShotRule;

    @Test
    public void LocationCompairsonTest () throws Exception {

        //Get the URL Home Page
        driver.get(KayakCarHomePage.HomePageURl(null));

        String HomePageTextMessage = HomePageTitle.HomePageTitleText(driver).getText();

        //Verify HomePageMessage Is Displayed and Spelled Correctly
        assertEquals(HomePageTextMessage, HomePageTitle.HomePageTitleText(driver).getText());

        //Set PickUp City
        KayakCarPickUpSearchBox.SearchBox(driver).click();
        KayakCarPickUpSearchBox.SearchBox(driver).clear();
        KayakCarPickUpSearchBox.SearchBox(driver).sendKeys("San Francisco, CA");

        // Select First Option
        FirstPickUpSearchOption.SelectFirstOption(driver).click();
        Thread.sleep(1000);

        //Select KayakCarPickUpDate Date
        KayakCarPickUpDate.PickUpDate(driver).click();

        String format = "mm/dd/yyyy";
        String date = "11/06/2015";
        SimpleDateFormat simpleFormat = new SimpleDateFormat("mm/dd/yyyy");

        java.text.DateFormat df = new java.text.SimpleDateFormat(format);
        java.util.Calendar calendar = java.util.Calendar.getInstance();

        calendar.setTime(df.parse(date));
        calendar.add(java.util.Calendar.DAY_OF_MONTH, +1);
        String formattedpickup = simpleFormat.format(calendar.getTime());
        System.out.println("The pick up date has been selected as" + "" + formattedpickup);

        KayakCarPickUpDate.PickUpDate(driver).clear();
        KayakCarPickUpDate.PickUpDate(driver).sendKeys(formattedpickup);
        KayakCarPickUpDate.PickUpDate(driver).sendKeys(Keys.TAB);
        Thread.sleep(1000);

        //Select KayakCarDropOffDate

        calendar.setTime(df.parse(date));
        calendar.add(java.util.Calendar.DAY_OF_MONTH, +3);
        String formatteddropoff = simpleFormat.format(calendar.getTime());
        System.out.println("The drop off date has been selected as" + "" + formatteddropoff);

        KayakCarDropOffDate.DropOffDate(driver).clear();
        KayakCarDropOffDate.DropOffDate(driver).sendKeys(formatteddropoff);
        KayakCarDropOffDate.DropOffDate(driver).sendKeys(Keys.TAB);
        Thread.sleep(1000);

        //Submit Search
        KayakCarSearchButton.SubmitSearchButton(driver).click();
        Thread.sleep(1000);

        //Closing the first tab with Compare vs. KAYAK window's

        ArrayList < String > tabs2 = new ArrayList < String > (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        //Get DropOff Location Car Prices with WebDriverWait to ignore StaleElementReferenceException  
        new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='priceValue'][1]")));

        //Car Prices 

        String SameLocationLowestPriceCar = driver.findElement(By.xpath("//*[@class='priceValue'][1]")).getText().substring(1);

        int Price1 = Integer.parseInt(SameLocationLowestPriceCar);

        System.out.println("The lowest price of same location return has been set as" + "" + SameLocationLowestPriceCar);
        System.out.println(Price1);

        //Get the URL Home Page
        driver.get(KayakCarHomePage.HomePageURl(null));

        //Verify HomePageMessage Is Displayed and Spelled Correctly
        assertEquals(HomePageTextMessage, HomePageTitle.HomePageTitleText(driver).getText());

        DifferentDropOffLocationButton.DropOffLocationButton(driver).click();

        //Set PickUp City
        KayakCarPickUpSearchBox.SearchBox(driver).click();
        KayakCarPickUpSearchBox.SearchBox(driver).clear();
        KayakCarPickUpSearchBox.SearchBox(driver).sendKeys("San Francisco, CA");
        String PickUpCity = ("San Francisco, CA");
        System.out.println("Kayak Car Pick Up City Has Been Set To: " + PickUpCity);

        // Select First Option with injection to avoid StaleElementReferenceException

        new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.name("pickup")));

        WebElement pickup = driver.findElement(By.name("pickup"));
        pickup.click();
     
        FirstPickUpSearchOption.SelectFirstOption(driver).click();
        Thread.sleep(1000);

        //Set DropOff City
        KayakCarDropOffSearchBox.SearchBox(driver).click();
        KayakCarDropOffSearchBox.SearchBox(driver).clear();
        KayakCarDropOffSearchBox.SearchBox(driver).sendKeys("Oakland, CA");
        KayakCarDropOffSearchBox.SearchBox(driver).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String DropOffCity = ("Oakland, CA");
        System.out.println("Kayak Car Drop Off City Has Been Set To: " + DropOffCity);

        //Select KayakCarPickUpDate Date
        KayakCarPickUpDate.PickUpDate(driver).click();

        calendar.setTime(df.parse(date));
        calendar.add(java.util.Calendar.DAY_OF_MONTH, +1);
        System.out.println("The pick up date has been selected as" + " " + " " + formattedpickup);

        KayakCarPickUpDate.PickUpDate(driver).clear();
        KayakCarPickUpDate.PickUpDate(driver).sendKeys(formattedpickup);
        KayakCarPickUpDate.PickUpDate(driver).sendKeys(Keys.TAB);
        Thread.sleep(1000);

        //Select KayakCarDropOffDate

        calendar.setTime(df.parse(date));
        calendar.add(java.util.Calendar.DAY_OF_MONTH, +3);
        System.out.println("The drop off date has been selected as" + " " + " " + formatteddropoff);

        KayakCarDropOffDate.DropOffDate(driver).clear();
        KayakCarDropOffDate.DropOffDate(driver).sendKeys(formatteddropoff);
        KayakCarDropOffDate.DropOffDate(driver).sendKeys(Keys.TAB);
        Thread.sleep(1000);

        //Submit Search
        KayakCarSearchButton.SubmitSearchButton(driver).click();
        Thread.sleep(3000);
        
        //Closing the first tab with Compare vs. KAYAK window's
        ArrayList < String > tabs21 = new ArrayList < String > (driver.getWindowHandles());
        driver.switchTo().window(tabs21.get(0));
        driver.close();
        driver.switchTo().window(tabs21.get(1));

        //Get DropOff Location Car Prices with WebDriverWait to ignore StaleElementReferenceException  
        new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='priceValue'][1]")));

        //String to get Different Car Location Return Lowest Price by trimming $ from attribute
        String DifferentLocationLowestPriceCar = driver.findElement(By.xpath("//span[@class='priceValue'][1]")).getText().substring(1);
        DifferentLocationLowestPriceCar.substring(1);

        //Convert Text To Integer
        int Price2 = Integer.parseInt(DifferentLocationLowestPriceCar);
        System.out.println("The lowest price of different location return has been set as" + "" + Price2);

        System.out.println(DifferentLocationLowestPriceCar);

        System.out.println(SameLocationLowestPriceCar == DifferentLocationLowestPriceCar); // prints false

        if (Price1 >= Price2) {
            System.out.println("Value Of Price1(" + Price1 + ") Is Greater Than Or Equals To Value Of Price2(" + Price2 + ").");
        } else {
            System.out.println("Value Of Price1(" + Price1 + ") Is Smaller Than Value Of Price2(" + Price2 + ").");
        }
    }
}