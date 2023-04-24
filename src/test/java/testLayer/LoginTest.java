package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMclass;
import pompackage.Pomlogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMclass {
	
	Pomlogin log;
	public LoginTest () {
		
		super();
		
	}
	
 @BeforeMethod
 public void initsetup() {
initiate();
screenshots("Login");


log= new Pomlogin();

 }

 @Test(priority=1)
 
 public void title() {
	String actual= log.verify();
	Assert.assertEquals(actual,"OrangeHRM");
 }
	@DataProvider
	public Object [][]details(){
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
		
	}
	 
 @Test(priority=2, dataProvider="details")
 public void Login(String name , String Password) {
log.typeusername(name);	 
log.typepassword(Password);
log.clickbutton();	 
 }
	
@AfterMethod
public void close() {
	driver.close();
}

 
}
	
	