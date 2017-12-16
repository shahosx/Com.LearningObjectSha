package com.LO.uiAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {
WebDriver driver;

	public Registration(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using= "#name_3_firstname")
	WebElement firstName;
	
	@FindBy(how=How.CSS, using= "#name_3_lastname")
	WebElement lastName;
	
	@FindBy(how=How.XPATH, using= "//*[text()='Single']")
	WebElement maritalStatus;
	
	@FindBy(how=How.XPATH, using= "//input[@name='checkbox_5[]' and @value='reading']")
	WebElement hobbyReading;
	
	@FindBy(how=How.XPATH, using= "//input[@name='checkbox_5[]' and @value='cricket']")
			WebElement hobbyCricket;
	
// Select ctry = new Select (driver.findElement(By.id("dropdown_7")));

	
	@FindBy(how=How.XPATH, using= "//select[@id='dropdown_7']/option//following::*[contains(text(),'United States')]")
	WebElement country;
	
	@FindBy(how=How.XPATH, using= "//*[@id='mm_date_8']/option/following::option[@value='3']")
	WebElement dobMonth;
	
	@FindBy(how=How.XPATH, using= "//*[@id='dd_date_8']/option/following::option[@value='17']")
	WebElement dobDate;
	
	@FindBy(how=How.XPATH, using= "//*[@id='yy_date_8']/option/following::option[@value='1990']")
	WebElement dobYear;
	
	@FindBy(how=How.CSS, using="#phone_9")
	WebElement phone;
	
	@FindBy(how=How.CSS, using= "#username")
	WebElement userName;
	
	@FindBy(how=How.CSS, using= "email_1")
	WebElement email;
	
	@FindBy(how=How.XPATH, using= "//input[@id='name_3_firstname']")
	WebElement AutoIT;
	
	@FindBy(how=How.CSS, using= "#description")
	WebElement description;
	
	@FindBy(how=How.CSS, using= "#password_2")
	WebElement password;
	@FindBy(how=How.CSS, using= "#confirm_password_password_2")
	WebElement confPassword;
	
	@FindBy(how=How.CSS, using= "#piereg_passwordStrength")
	WebElement strengthIndicator;
	
	
	@FindBy(how=How.CSS, using= "#submit")
	WebElement submit;
	
	@FindBy(how=How.XPATH, using= "#piereg_message")
	WebElement confRegistration;
	
	
	public String getStrengthIndicator() {
		return this.strengthIndicator.getText();
	}
	
	public String getConfRegistration () {
		return this.confRegistration.getText();
	}

	//init page factory
	
	
	//init webdriver
	
	
	public void newRegistration (String strFirstName, String strLastName, String strPhone, String strUserName, String strEmail, String strDescription, String strPassword, String strConfirmPassword  ) {
		this.firstName.sendKeys(strFirstName);
		this.lastName.sendKeys(strLastName);
		this.maritalStatus.click();
		this.hobbyReading.click();
		this.hobbyCricket.click();
		this.country.click();
		this.dobMonth.click();
		this.dobDate.click();
		this.dobYear.click();
		this.phone.sendKeys(strPhone);
		this.userName.sendKeys(strUserName);
		this.email.sendKeys(strEmail);
		this.description.sendKeys(strDescription);	
		this.password.sendKeys(strPassword);
		this.confPassword.sendKeys(strConfirmPassword);
		this.submit.click();
		
	}
	
	
	
	
	
	
	// testNg annotation for all the elements
	
	
	//one method to invoke all elements
	
	
	
}
