package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		driver = webdriver.Chrome(ChromeDriverManager().install());
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver_chrome_133\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();                  // Automatically sets up the driver

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(groups = { "Alumini" })
	public void signin() throws InterruptedException {
		driver.get("https://ewuian.softbd.xyz/");

		WebElement signin = driver
				.findElement(By.xpath("//button[@class='btn btn-info btn-lg registar-popup']/img[@alt]"));
		signin.click();
		Thread.sleep(2000);

		WebElement emailfld = driver.findElement(By.id("userSigninLogin"));
		emailfld.sendKeys("qliq.spacecats@gmail.com");

		WebElement passwordfld = driver.findElement(By.id("userSigninPassword"));
		passwordfld.sendKeys("Ewuian@1234");

		WebElement signinBtn = driver.findElement(By.xpath("//button[contains(text(), 'SIGN IN')]"));
		signinBtn.click();

		Thread.sleep(5000);
	}

	@Test(groups = { "Alumini" })
	public void inportpersonalInformation() throws InterruptedException {

		WebElement uploadPicture = driver.findElement(By.xpath("//img[@src='https://ewuian.softbd.xyz/themes/east-west-alumni/assets/img/icon/upload-icon.png']"));
		uploadPicture.click();
		
		// Locate the file input element
        WebElement fileInput = driver.findElement(By.id("file-upload"));

        // Provide the full path of the file from your PC
        String filePath = "D:\\Nayem\\Pictures\\nayem.jpg";
        fileInput.sendKeys(filePath);
		Thread.sleep(2000);

		driver.navigate().to("https://ewuian.softbd.xyz/");
		driver.navigate().back();
		Thread.sleep(2000);

	}

}
