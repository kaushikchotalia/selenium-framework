package com.kaushik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LiveDemoPage {
    WebDriver driver;

    //Constructor
    public LiveDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // All elemetns of the form
    @FindBy(css = "#support_contact>div>div>h2:nth-child(1)")
    private WebElement requestADemoText;

    @FindBy(id = "email")
    private WebElement emailIput;

    @FindBy(id = "company")
    private WebElement companyElm;

    @FindBy(css = "#demandbase-autocomplete ul  li a")
    private WebElement companySelectFromAutoComplete;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "description")
    private WebElement additionalInformation;

    @FindBy(id = "00Nd0000007MFAl")
    private WebElement selectTotalNumberOfEmployee;

    @FindBy(id = "country")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement selectProvience;

    @FindBy(id = "btnSubmit")
    private  WebElement submitBtn;


    // Modify by passing string
    public LiveDemoPage keyInTotalEmployee()
    {
        Select selectNumberOfEmployee = new Select(selectTotalNumberOfEmployee);
        selectNumberOfEmployee.selectByVisibleText("Just Me");
        return new LiveDemoPage(driver);
    }

    //Modify by passing string value in below method
    public LiveDemoPage keyInCountry()
    {
        Select countrySelection = new Select(selectCountry);
        countrySelection.selectByVisibleText("United States");
        return new LiveDemoPage(driver);
    }
    public LiveDemoPage keyInProvience()
    {
        Select provienceSelection = new Select(selectProvience);
        provienceSelection.selectByIndex(3);
        return new LiveDemoPage(driver);
    }

    public LiveDemoPage keyInEmail(String email)
    {
        this.emailIput.sendKeys(email);
        return this;
    }

    public LiveDemoPage keyInCompany(String company)
    {
        this.companyElm.sendKeys(company);
        return this;
    }
    public LiveDemoPage keyInFirstName(String firstName)
    {
        this.firstName.sendKeys(firstName);
        return this;
    }
    public LiveDemoPage keyInLastName(String lastName)
    {
        this.lastName.sendKeys(lastName);
        return this;
    }
    public LiveDemoPage keyInPhone(String phone)
    {
        this.phone.sendKeys(phone);
        return this;
    }
    public  LiveDemoPage keyInZipCode(String zipCode)
    {
        this.zipCode.sendKeys(zipCode);
        return this;
    }

    public LiveDemoPage keyAdditionalInformation(String additionalInfo)
    {
        this.additionalInformation.sendKeys(additionalInfo);
        return this;
    }

    public LiveDemoPage submitForm()
    {
        submitBtn.click();
        return new LiveDemoPage(driver);
    }

    public WebElement getTextFromLiveDemoPage()
    {
        return requestADemoText;
    }

}
