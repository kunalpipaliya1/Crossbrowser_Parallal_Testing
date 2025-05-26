import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallalTesting1 {
	
	@Test
	public void ParallalTesting() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Cloth");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
		// validate Cloth
		String actual = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/h2/span[3]")).getText();
		Assert.assertEquals( actual.trim(),"\"Cloth\"");
		
		System.out.println("This is Amazon Test: " + actual);
		
		driver.close();

	}

}
