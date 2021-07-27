package com.crm.qa.testcases;

import com.crm.qa.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class FlightBooking extends TestBase {
    Home_Page_BlazeDemo homePage=PageFactory.initElements(driver,Home_Page_BlazeDemo.class);
    Flight_Purchase purchasePage=PageFactory.initElements(driver,Flight_Purchase.class);;

    public FlightBooking() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();

    }

    /**
     * Test case Verifies booking flow gets completed without issues
     *
     */
    @Test(priority=1)
    public void bookFlight(){
        Assert.assertEquals(homePage.bookFlight("Boston","London"),true);
        Assert.assertEquals(homePage.selectFlight(),true);
        Assert.assertEquals(purchasePage.enterDetails("abc", "xyz", "pune", "Mh", 123, "Visa", 123, 05, 11, "shb"),true);
        String bookingId=purchasePage.verifyPurchase();
        if (bookingId.equals("")){
            Assert.assertTrue(false,"Id is null for booking, please refer screenshots for more details");
        }
        else{
            Assert.assertTrue(true,"Id is not null for booking: "+bookingId);
        }

    }

    /**
     * Test case Verifies same source and Destination cities can not be selected
     *
     */
    @Test(priority=2)
    public void verifyBookingForSameSourceAndDestination(){
        Assert.assertEquals(homePage.bookFlight("Boston","Boston"),false);

    }

    /**
     * Test case Verifies booking can not be proceeded if purchase etails are null
     *
     */
    @Test(priority=3)
    public void verifyNoBooking(){
        Assert.assertEquals(homePage.bookFlight("Boston","London"),true);
        Assert.assertEquals(homePage.selectFlight(),true);
        Assert.assertEquals(purchasePage.enterDetails("abc", "xyz", "pune", "Mh", 123, "Visa", 123, 05, 11, "shb"),true);
        String bookingId=purchasePage.verifyPurchase();
        if (bookingId.equals("")){
            Assert.assertTrue(true,"Id is null for booking, please refer screenshots for more details");
        }
        else{
            Assert.assertTrue(false,"Id is not null for booking: "+bookingId);
        }

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
