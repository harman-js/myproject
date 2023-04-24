package basepackage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class BaseHRMclass {
	
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	
	public BaseHRMclass() {
		
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\harma\\eclipse-workspace\\Orangehm\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException a) {
			
			a.printStackTrace();
			
		}}
		
		
		public static void initiate() {
			
						
		String browsername=	prop.getProperty("browser");
		
		
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			
			driver= new FirefoxDriver();}
			else if  (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\harma\\eclipse-workspace\\Orangehm\\chromedriver.exe");	
				ChromeOptions op=new ChromeOptions();
				op.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(op);
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(prop.getProperty("URL"));
		}
		
		
		public static void screenshots(String Filename ) {
		File file=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {	
		FileUtils.copyFile(file, new File("C:\\Users\\harma\\eclipse-workspace\\Orangehm\\src\\test\\java\\screenshots\\Screenshots" + Filename+".jpg"));
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}}}
		
		
	