package synchronization_wait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class A203_C61_Amazon_Payment_Implicitwait 
{

	@Test
	public void amazon_payment() throws EncryptedDocumentException, IOException, InterruptedException 
	{
	
		FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Selenium_Assignments\\DDT\\loginsheet.xlsx");
		Workbook w1= WorkbookFactory.create(file);
		String UN=NumberToTextConverter.toText(w1.getSheet("amazonlogin").getRow(0).getCell(0).getNumericCellValue());
		String PW=w1.getSheet("amazonlogin").getRow(0).getCell(1).getStringCellValue();
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		WebElement acccountslist = driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'] )[2]"));
		Actions a1=new Actions(driver);
		a1.moveToElement(acccountslist).perform();
		
		WebElement signin=driver.findElement(By.linkText("Sign in"));
		signin.click();
		
		WebElement email=driver.findElement(By.name("email"));
		email.sendKeys(UN + Keys.ENTER);
		//Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("ap_password"));
		password.sendKeys(PW + Keys.ENTER);
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoes" + Keys.ENTER);
		WebElement selectshoe= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[4]"));
		selectshoe.click();
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> id =ids.iterator();
		String Parent_id= id.next();
		String Child_id=id.next();
		
		driver.close();
		driver.switchTo().window(Child_id);
		
		WebElement buynow= driver.findElement(By.id("buy-now-button"));
		buynow.click();	
		
				
	}
	
	
	
}
