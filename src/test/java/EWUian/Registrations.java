package EWUian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Registrations {

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
	}

	@Test(enabled = false)
	public void DomainURLfalse() {
		driver.get("https://ewuian.softbd.xyz/");
	}

	@Test
	public void Scroll() throws InterruptedException {

		// Create JavaScript Executor
		JavascriptExecutor jsEx = (JavascriptExecutor) driver;

		// Scroll down to the bottom of the page
		jsEx.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000); 
		
		// Scroll back up to the top of the page
		jsEx.executeScript("window.scrollTo(0,.5, 0);");
		Thread.sleep(2000); 
	}

	@Test
	public void YouthRegistration1() throws InterruptedException {

		WebElement signinButton = driver.findElement(By
				.cssSelector("img[src='https://ewuian.softbd.xyz/themes/east-west-alumni/assets/img/Group-4121.png']"));
		signinButton.click();

// 		WebElement signupButton = driver.findElement(By.linkText("SIGN UP"));
// 		signupButton.click();

		driver.navigate().to("https://ewuian.softbd.xyz/registration");

		WebElement FullName = driver.findElement(By.xpath("//input[@id='name']"));
		FullName.sendKeys("Automation User");
	}

	@Test
	public void YouthRegistration2() throws InterruptedException {

		WebElement emailID = driver.findElement(By.xpath("//input[@id='email']"));
		emailID.sendKeys("qliq.spacecats@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Ewuian@1234");

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
		confirmPassword.sendKeys("Ewuian@1234");

		WebElement registrationButton = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
		registrationButton.click();

	}

	@Test
	public void YouthRegistration4() throws InterruptedException {
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "EAST WEST UNIVERSITY";
		
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("title pass");
		} else {
			System.out.println("title fail");
			System.out.println(driver.getTitle());
		}
	}
	
	@Test
	public void YouthSearch() throws IOException, InterruptedException { 

		driver.get("https://ewuian.softbd.xyz/");
		WebElement searchBox = driver.findElement(By.id("search_value"));
		searchBox.sendKeys("2014-2-50-012");		
		
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
		
		WebElement searchData = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		searchData.getText();
	}
	
	@Test
	public void TakeScreenShot() throws IOException, InterruptedException { 
		
//		WebElement RealData = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div/h5[3]"));	

//        Actions actions = new Actions(driver);   // Create an Actions object

        // Perform mouse hover action
//        actions.moveToElement(RealData).perform();
//        System.out.println("Mouse hovered successfully!");
		
		
		driver.get("https://ewuian.softbd.xyz/");
		WebElement searchBox = driver.findElement(By.id("search_value"));
		searchBox.sendKeys("2014-2-50-012");		
		
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
		
		WebElement searchData = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		searchData.getText();
		
        
		JavascriptExecutor js = (JavascriptExecutor) driver;     // Create JavaScript Executor

		smoothScroll(js, 300, true);     // Scroll down in 500px steps  // Scroll down smoothly
		Thread.sleep(2000);     
      	
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File screenshot = searchData.getScreenshotAs(OutputType.FILE);
			
//		take screen shot..........
		FileUtils.copyFile(screenshot, new File("D:\\screenshot\\ScreenShot2001.png"), true);
		
		System.out.println("Screenshot saved successfully!");	
	}
	
	private void smoothScroll(JavascriptExecutor js, int i, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void closeDriver() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}

