package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Flight_Purchase extends TestBase {

    @FindBy(xpath = ("//input[@id='inputName']"))
    WebElement name;

    @FindBy(xpath = ("//input[@id='address']"))
    WebElement address;

    @FindBy(xpath = ("//input[@id='city']"))
    WebElement city;

    @FindBy(xpath = ("//input[@id='state']"))
    WebElement state;

    @FindBy(xpath = ("//input[@id='zipCode']"))
    WebElement zipCode;


    @FindBy(xpath = ("//select[@id='cardType']"))
    WebElement cardType;

    @FindBy(xpath = ("//input[@id='creditCardNumber']"))
    WebElement creditCardNumber;

    @FindBy(xpath = ("//input[@id='creditCardMonth']"))
    WebElement creditCardMonth;

    @FindBy(xpath = ("//input[@id='creditCardYear']"))
    WebElement creditCardYear;

    @FindBy(xpath = ("//input[@id='nameOnCard']"))
    WebElement nameOnCard;

    @FindBy(xpath = ("//input[@value='Purchase Flight']"))
    WebElement purchaseFlightBtn;

    @FindBy(xpath = ("//h1"))
    WebElement purchaseHeader;

    @FindBy(xpath = ("//td[text()='Id']/..//td[2]"))
    WebElement idOfPurchase;



    // Initializing the Page Objects:
    public Flight_Purchase() {
        PageFactory.initElements(driver, this);
    }

    private boolean flag;

    WebDriverWait wait = new WebDriverWait(driver,30);
    /**
     * Types all required details on purchase page
     * @param userName
     * @param userAddress
     * @param userCity
     * @param userState
     * @param userZipCode
     * @param userCardType
     * @param cardNumber
     * @param cardMonth
     * @param cardYear
     * @param nameonCard
     * @return boolean
     */
    public boolean enterDetails(String userName, String userAddress, String userCity, String userState, int userZipCode,String userCardType,int cardNumber,int cardMonth,int cardYear,String nameonCard) {
        try{

            wait.until(ExpectedConditions.visibilityOfElementLocated((By) name));
            name.sendKeys(userName);
            address.sendKeys(userAddress);
            city.sendKeys(userCity);
            state.sendKeys(userState);
            zipCode.sendKeys(String.valueOf(userZipCode));

            Select cardtype = new Select(cardType);
            cardtype.selectByVisibleText(userCardType);
            creditCardNumber.sendKeys(String.valueOf(cardNumber));
            creditCardMonth.sendKeys(String.valueOf(cardMonth));
            creditCardYear.sendKeys(String.valueOf(cardYear));
            nameOnCard.sendKeys(nameonCard);
            purchaseFlightBtn.click();
            flag=true;
        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());
            flag=false;
        }


        return flag;
    }

    /**
     * Verifies purchase and returns the id of purchase
     *
     * @return purchaseId -- type String
     */
    public String verifyPurchase(){
        String purchaseId="";

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) purchaseHeader));
            Assert.assertEquals(purchaseHeader.getText(),"Thank you for your purchase today!");
            purchaseId=idOfPurchase.getText();
            System.out.println("purchase id is :"+purchaseId);
        }
        catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage()+ "at line number "+e.getStackTrace()[0].getLineNumber());

        }
        return purchaseId;
    }

}

