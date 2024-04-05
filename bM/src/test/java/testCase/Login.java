package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Login {
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void setup() {
		
		driver.get("https://crm.nirojprasain.com.np");
		driver.manage().window().maximize();
	}

	
	@AfterTest
	public void endTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test (priority=1)
	public void LoginWithValidDetails() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://crm.nirojprasain.com.np");
//		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("admin@dev.com");
		driver.findElement(By.id("password")).sendKeys("pass");
		WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div[2]/div[2]/form/div[4]/button"));
		button.click();
		Assert.assertTrue(driver.getTitle().contains("Dashboard | CRM"));
//		Thread.sleep(2000);
//		driver.quit();

	}
	@Test (priority=3)
	public void LoginWithInValidDetails() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://crm.nirojprasain.com.np");
//		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("admin@dev.com");
		driver.findElement(By.id("password")).sendKeys("pass1");
		WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div[2]/div[2]/form/div[4]/button"));
		button.click();
		String message = driver.findElement(By.className("alert alert-danger")).getText();
		Assert.assertTrue(message.contains("These credentials do not match our records."));
//		Thread.sleep(2000);
//		driver.quit();
	}
	@Test (priority=2)
	public void ForgetPassword() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://crm.nirojprasain.com.np");
//		driver.manage().window().maximize();
		WebElement forgotLink = driver.findElement(By.linkText("Forgot Password"));
		Thread.sleep(1000);
		forgotLink.click();
//		Thread.sleep(3000);
//		driver.quit();
		
	}
	
	
	
}
	

