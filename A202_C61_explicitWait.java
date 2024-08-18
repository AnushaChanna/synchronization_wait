package synchronization_wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class A202_C61_explicitWait
{
	@Test
	public void explicitwait()
	{
		ChromeDriver driver=new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		
		WebDriverWait w1=new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.titleContains("0")); 
		// if this condition fails then it'll wait till 10secs and throw timeoutexception
		
		driver.findElement(By.name("q")).sendKeys("india" + Keys.ENTER);
		// if this condition fails then it'll wait till 10secs and throw NoSuchElementFound exception
		
		//driver.findElement(By.name("m")).sendKeys("india"+Keys.ENTER);
		
	}
}
