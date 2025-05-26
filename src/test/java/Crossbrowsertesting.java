import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Crossbrowsertesting {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void Launchbrowser(String browser) {
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		
	
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		

		default :
			driver = null;
			break;
		
		}
	}
	
	@Test
	public void verifytitle() throws InterruptedException {
		driver.get("https://www.google.com/");
		String expectedtitle = "Google";
		String actualtitle = driver.getTitle();
		
		Assert.assertEquals(expectedtitle, actualtitle);
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void Quit() {
		driver.quit();
	}

}
