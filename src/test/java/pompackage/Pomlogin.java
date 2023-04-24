package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMclass;

public class Pomlogin extends BaseHRMclass {
	
@FindBy(name="username") WebElement uname;
@FindBy(name="password") WebElement password;
//@FindBy(XPath=="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement loginbtn;
//driver.find_element(By.XPATH, "xpath")
///html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button

@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement loginbtn;

public Pomlogin () {
	
	PageFactory.initElements(driver, this);
}


	public void typeusername(String name) {
		
		
		uname.sendKeys(name);
	}

	public void typepassword(String pass) {
		
		
		password.sendKeys(pass);
	
	}
	
	
	  public void clickbutton() {
	  
	  
	  loginbtn.click(); }
	 
	
	public String verify() {
		return driver.getTitle();
	}
}
