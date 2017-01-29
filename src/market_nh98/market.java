package market_nh98;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class market extends TestBase {
	
		@BeforeClass
		public void beforetest() throws IOException{
		initialize();
		}
	
		@Test
		public void marketload(){
			driver.get(CONFIG.getProperty("testSiteName"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for(int i=1; i<3; i++){
			
			postcomment(i);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
		@AfterTest
		public void exittest(){
		driver.quit();
		}
		
	
	
}
