package practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MakeMyTrip {
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bhubane"+Keys.ENTER);
		driver.findElement(By.xpath("//p[text()='Bhubaneswar, India']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("bang");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		while(true) {
			try {
			driver.findElement(By.xpath("//div[@aria-label='Sat Dec 03 2022']")).click();
				break;
			}
			catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.quit();
		
		
		
	}

}
