package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuccessStoryPreview {

	WebDriver driver;

	@BeforeClass
	public void selectChromeDriver() {
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
	

	@Test(groups = { "SuccessStory" })
	public void SuccessStory1() throws InterruptedException {

		WebElement SuccessStory = driver.findElement(By.cssSelector("#mobilemenu > li:nth-child(3) > a"));
		SuccessStory.click();

		System.out.println(driver.getTitle());
	}

	
	@Test(groups = { "SuccessStory" }, enabled = false)
	public void SuccessStory3() throws InterruptedException {

		WebElement SuccessStoryCheck1 = driver.findElement(By.cssSelector(
				"body > div.section-padding.current-event > div > div > div:nth-child(2) > div.col-lg-8.col-md-6.col-sm-6.blog-right > div > h3 > a"));

		Actions action = new Actions(driver);
		action.moveToElement(SuccessStoryCheck1).perform();
		Thread.sleep(2000);

	}
	
	
	@Test(groups = { "SuccessStory" }, enabled = false)
	public void SuccessStory5() throws InterruptedException {

		// Create JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down smoothly
		smoothScroll(js, 500, true); // Scroll down in 500px steps
		Thread.sleep(2000);

		// Scroll back up smoothly
		smoothScroll(js, -500, false); // Scroll up in 500px steps
		Thread.sleep(2000);

	}

	// Smooth scrolling function
	private static void smoothScroll(JavascriptExecutor js, int step, boolean scrollDown) throws InterruptedException {
		long scrollHeight = (long) js.executeScript("return document.body.scrollHeight;");
		long currentPosition = (long) js.executeScript("return window.pageYOffset;");

		if (scrollDown) {
			// Scroll Down
			while (currentPosition < scrollHeight) {
				js.executeScript("window.scrollBy(0, " + step + ");");
				currentPosition = (long) js.executeScript("return window.pageYOffset;");
				Thread.sleep(500); // Adjust speed (increase for slower scrolling)
			}
		} else {
			// Scroll Up
			while (currentPosition > 0) {
				js.executeScript("window.scrollBy(0, -" + step + ");");
				currentPosition = (long) js.executeScript("return window.pageYOffset;");
				Thread.sleep(500);
			}
		}

	}

	@Test(groups = { "SuccessStory" })
	public void SuccessStory2() throws InterruptedException {

		WebElement SuccessStoryCheck21 = driver.findElement(By.cssSelector(
				"body > div.section-padding.current-event > div > div > div:nth-child(2) > div.col-lg-8.col-md-6.col-sm-6.blog-right > div > h3 > a"));

		WebElement SuccessStoryCheckMoreButton = driver.findElement(By.cssSelector(
				"body > div.section-padding.current-event > div > div > div:nth-child(2) > div.col-lg-8.col-md-6.col-sm-6.blog-right > div > div > a"));
	
		Actions action = new Actions(driver);
		action.moveToElement(SuccessStoryCheckMoreButton).perform();
		Thread.sleep(2000);
		
		String representativeName = SuccessStoryCheck21.getText(); // Get text from the element
		System.out.println("Extracted Text: " + representativeName); // Print the extracted text
	}

	
	@Test(groups = { "SuccessStory" }, enabled = false)
	public void PreviewSuccessStory() {

//		WebElement PreviewSuccessStory1 = driver.findElement(By.xpath("//div[@class='section-padding current-event']//div[2]//div[2]//div[1]//div[1]//a[1]"));            
//		PreviewSuccessStory1.click();
		
		driver.navigate().to("");
		System.out.println(driver.getTitle());
	}
	
}


