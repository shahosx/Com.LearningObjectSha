package LO.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.LO.TestBase.TestBase;
import com.LO.uiAction.Registration;

public class TestRegistration extends TestBase{ 
	// define class

	
	//open browser and go the url
	@BeforeTest
	public void Setup() {
		this.init();
	}
	// tests
	@Test (priority=1)
	public void RegisterWithInvalidPass() {
		Registration objRegist= PageFactory.initElements(driver, Registration.class);
		objRegist.newRegistration("Shahadat", "Hossain", "347-111-1111", "LearningObjSha", "abc@yahoo.com", 
				 "Hello 123", "123", "123");
		String verifyPassIndicator = objRegist.getStrengthIndicator();
		Assert.assertEquals("VeryWeak", verifyPassIndicator);
		
	}
	
	@Test (priority=2)
	public void RegisterWithWeakPass() {
	Registration objRegist= PageFactory.initElements(driver, Registration.class);
	objRegist.newRegistration("Shahadat", "Hossain", "347-111-1111", "LearningObjSha", "abc@yahoo.com", 
			 "Hello 123", "Passwordisweak111333999", "Passwordisweak111333999");
	
	
	String verifyPassIndicator = objRegist.getStrengthIndicator();
	Assert.assertEquals("VeryWeak", verifyPassIndicator);
	}
	
	@Test (priority=3)
	public void RegisterWithStrongPass() {
	Registration objRegist= PageFactory.initElements(driver, Registration.class);

	objRegist.newRegistration("Shahadat", "Hossain", "347-111-1111", "LearningObjSha", "abc@yahoo.com", 
			 "Hello 123", "Pass@Strong##@@!!!99", "Pass@Strong##@@!!!99");
	String verifyPassIndicator = objRegist.getStrengthIndicator();
	Assert.assertTrue(verifyPassIndicator.contains("Strong"));
	}
	
	@AfterMethod
		public void tearDown(ITestResult result)
		{
		if(ITestResult.FAILURE==result.getStatus())
		{
		try 
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshotss/"+result.getName()+".png"));
		System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{

		System.out.println("Exception while taking screenshot "+e.getMessage());
		}}}
	
	
@AfterTest
public void cleanUp() {
	driver.close();
}
	
	
	
	// Screenshot for fail
 
	
	
}
