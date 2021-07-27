package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page_BlazeDemo extends TestBase {

    @FindBy(xpath = ("//select[@name = 'fromPort']"))
    WebElement depCity;

    @FindBy(xpath = ("//select[@name = 'toPort']"))
    WebElement desCity;


    @FindBy(xpath = ("//input[@value = 'Find Flights']"))
    WebElement findFlights;

    @FindBy(xpath = ("(//input[@type='submit'])[1]"))
    WebElement selectFirstAirline;
    // Initializing the Page Objects:
    public Home_Page_BlazeDemo() {
        PageFactory.initElements(driver, this);
    }

    private boolean flag;
    public Select city;
    WebDriverWait wait = new WebDriverWait(driver,10);
//    public Home_Page_BlazeDemo(WebDriver driver)
//    {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//
//    }



    /**
     * Selects the departure city from UI pass city name value as argument
     * @param cityName  --type String
     * @return boolean

     */
    public boolean selectdepcity(String cityName) {
        System.out.println(driver);
        flag =false;
        try{
            city = new Select(depCity);
            city.selectByVisibleText(cityName);
            System.out.println("Departure city selected");
            flag=true;

        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());
            flag=false;
        }
        return flag;
    }
    /**
     * Selects the destination city from UI pass city name value as argument
     * @param cityName --type String
     * @return boolean

     */
    public boolean selectdescity(String cityName) {
        flag =false;
        try{
            city = new Select(desCity);
            city.selectByVisibleText(cityName);
            System.out.println("Destination city selected");
            flag=true;
        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());
            flag=false;
        }
        return flag;


    }
    /**
     * Selects the departure and destination city and clicks on submit button
     * @param departureCity  --type String
     * @param destinationCity --type String
     * @return boolean

     */
    public boolean bookFlight(String departureCity,String destinationCity){
        flag =false;
        try{
            selectdepcity(departureCity);
            selectdescity(destinationCity);
            findFlights.click();

        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());
            flag=false;
        }
        return flag;
    }

    public boolean selectFlight(){
        flag =false;
        try{
            //WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) selectFirstAirline));
            selectFirstAirline.click();
            flag=true;

        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());
            flag=false;
        }
        return flag;
    }

}
