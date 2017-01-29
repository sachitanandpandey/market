package market_nh98;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	// initalizing the properties 
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static WebDriver dri =null;
	public static EventFiringWebDriver driver = null;
	public static boolean isLoggedIn=false;
	
	
	
	public void initialize() throws IOException{
//		FirefoxDriver dri = new FirefoxDriver();
	
		
	if (driver == null){
		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src/config/config.properties");
		CONFIG.load(fn);
		
		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")+"//src/config/OR.properties");
		OR.load(fn);
		if (CONFIG.getProperty("browser").equals("Firefox")){
			ProfilesIni profilesIni = new ProfilesIni();
			FirefoxProfile p = profilesIni.getProfile("market");
			dri = new FirefoxDriver(p);
		}
		if (CONFIG.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/sachitanand/Documents/selenium-2.52.0/drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
		}
			
			
//			dri = new FirefoxDriver();
		
		
		
		}
		
		driver = new EventFiringWebDriver(dri);
		
		

		
	}
//	}	

	 public static WebElement getobject (String xpath){
	  try{
		return driver.findElement(By.xpath(OR.getProperty(xpath)));
	 }
	 catch(Throwable t ){System.out.println("element not found");}
	return null;
}
	 public void postcomment(int i){
		    Random random = new Random();
		    int rnum = random.nextInt(1000000);
		    System.out.println(rnum);
			String messager = CONFIG.getProperty("message");
			String thandle = CONFIG.getProperty("t"+i);
			String message = messager+thandle;
			driver.findElement(By.xpath(OR.getProperty("tbutton"))).click();
			driver.findElement(By.xpath(OR.getProperty("tweetbox"))).sendKeys(message + " #"+rnum);
			driver.findElement(By.xpath(OR.getProperty("tweetit"))).click();
			

	 }
	 
}