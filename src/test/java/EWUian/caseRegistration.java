package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class caseRegistration {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver_chrome_133\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();                  // Automatically sets up the driver

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void DomainURL() {
		driver.get("https://ewuian.softbd.xyz/");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void Scroll() throws InterruptedException {

		JavascriptExecutor jsEx = (JavascriptExecutor) driver;               	  // Create JavaScript Executor
		jsEx.executeScript("window.scrollTo(0, document.body.scrollHeight);");      // Scroll down to the bottom of the page
		Thread.sleep(2000); 
		
		jsEx.executeScript("window.scrollTo(0, .5, 0);");      		// Scroll back up to the top of the page
		Thread.sleep(2000); 
	}
	
	@Test  (groups = { "registration" })
	public void YouthRegistration1() throws InterruptedException {

		WebElement signinButton = driver.findElement(By
				.cssSelector("img[src='https://ewuian.softbd.xyz/themes/east-west-alumni/assets/img/Group-4121.png']"));
		signinButton.click();

		driver.navigate().to("https://ewuian.softbd.xyz/registration");

		WebElement FullName = driver.findElement(By.xpath("//input[@id='name']"));
		FullName.sendKeys("Automation User");
	}

	@Test   (groups = { "registration using duplicate data" })
	public void YouthRegistration_Case1() throws InterruptedException {

		WebElement emailID = driver.findElement(By.xpath("//input[@id='email']"));
		emailID.sendKeys("qliq.spacecats@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Ewuian@1234");

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
		confirmPassword.sendKeys("Ewuian@1234");

		WebElement registrationButton = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
		registrationButton.click();
	}
	
	@Test      (groups = { "registration using wrong password" })
	public void YouthRegistration_Case2() throws InterruptedException {

		WebElement emailID = driver.findElement(By.xpath("//input[@id='email']"));
		emailID.sendKeys("ewu.alumi@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Ewuian@1234");

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
		confirmPassword.sendKeys("Ewuian@165432234");

		WebElement registrationButton = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
		registrationButton.click();
	}
	
	@Test      (groups = { "registration by null data" })
	public void YouthRegistration_Case3() throws InterruptedException {

		WebElement emailID = driver.findElement(By.xpath("//input[@id='email']"));
		emailID.clear();
		emailID.sendKeys(" ");

		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.clear();
		password.sendKeys(" ");

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
		confirmPassword.clear();
		confirmPassword.sendKeys(" ");

		WebElement registrationButton = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
		registrationButton.click();

//		WebElement alertForRequiredElementfield = driver.findElement(By.xpath("//span[@for='name']"));
//		System.out.println(alertForRequiredElementfield);
	}

}



