package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class ScrollPage {

	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver_chrome_133\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();                  // Automatically sets up the driver

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(description = "Smooth scrolling")
	public void scroll() throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://ewuian.softbd.xyz/");
		driver.manage().window().maximize();

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
		} 
		else {
			                                                             // Scroll Up
			while (currentPosition > 0) {
				js.executeScript("window.scrollBy(0, -" + step + ");");
				currentPosition = (long) js.executeScript("return window.pageYOffset;");
				Thread.sleep(500);
			}
		}

	}

}





