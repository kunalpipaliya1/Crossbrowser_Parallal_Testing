import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallalTesting2 {
	
	@Test
	public void ParallalTesting() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Cloth", Keys.ENTER);		
		Thread.sleep(2000);
		
		// validate Cloth
		String actual = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span/span")).getText();
		Assert.assertEquals( actual.trim(),"Cloth");
		
		System.out.println("This is Flipkart Test: " + actual);									
		driver.close();

	}

}

/* Note - when we use parallel testing we need to add below line in testng suite.
<suite name="Suite" parallel="classes" thread-count="2"> */

