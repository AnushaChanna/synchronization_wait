package synchronization_wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A201_C61_ImplicitWait 
{
@Test
public void implicitwait()
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	
	//driver.findElement(By.name("q")).sendKeys("india"+Keys.ENTER); //---- this will execute the prg without any error
	driver.findElement(By.name("m")).sendKeys("india"+Keys.ENTER); // it will wait till 10 sec and throw nosuchelementfound
}	
}
