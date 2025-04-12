package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobSearch {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver_chrome_133\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();                  // Automatically sets up the driver

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, groups = "Job")
	public void JobSearch_step1() throws InterruptedException {
		driver.get("https://ewuian.softbd.xyz/");
	}

	@Test(priority = 2, groups = "Job")
	public void JobSearch_step2() throws InterruptedException {

		WebElement signin = driver
				.findElement(By.xpath("//button[@class='btn btn-info btn-lg registar-popup']/img[@alt]"));
		signin.click();
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = "Job")
	public void JobSearch_step3() throws InterruptedException {

		WebElement emailfld = driver.findElement(By.id("userSigninLogin"));
		emailfld.sendKeys("tarikul.ewu@gmail.com");
		WebElement passwordfld = driver.findElement(By.id("userSigninPassword"));
		passwordfld.sendKeys("Nayem@2888");

		WebElement signinBtn = driver.findElement(By.xpath("//button[contains(text(), 'SIGN IN')]"));
		signinBtn.click();
		Thread.sleep(3000);
	}

	@Test(priority = 4, groups = "Job")
	public void JobSearch_step4() throws InterruptedException {

		WebElement signinBtn = driver.findElement(By.cssSelector("#mobilemenu > li:nth-child(4) > a"));
		signinBtn.click();
		Thread.sleep(3000);
	}

	@Test(priority = 5, groups = "Job")
	public void JobSearch_step5() throws InterruptedException {

		WebElement categoryDropDown = driver.findElement(By.name("category_id"));
		categoryDropDown.click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(categoryDropDown).perform();

		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
	}

	@Test(priority = 6, groups = "Job")
	public void JobSearch_step6() throws InterruptedException {

		WebElement categoryDropDown = driver.findElement(By.cssSelector(
				"body > div.blog-grid.section-padding > div > div.row.mb-30 > div.col-lg-4 > div > div > div > ul > li:nth-child(14) > button\r\n"));
		System.out.println(categoryDropDown.getText());
		Thread.sleep(3000);
	}

	@Test(priority = 7, groups = "UpdateAccount")
	public void UpdateAccount() throws InterruptedException {

		WebElement accountButton = driver.findElement(By.cssSelector(
				"body > div.main-menu > div > div.row.margin-bottom-4per > div.col-md-3 > div > a:nth-child(1)"));
		accountButton.click();

		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
	}

	@Test(priority = 8, groups = "UpdateAccount", enabled = false)
	public void UpdateProfilePicture() throws InterruptedException {

		WebElement UpdateProfilePicture = driver.findElement(By.cssSelector("label[for='profile_pic']"));
		UpdateProfilePicture.click();

		UpdateProfilePicture.sendKeys("D:\\Nayem\\Avater\\sag.png");

		WebElement confirmProfilePicture = driver.findElement(By.cssSelector(
				"#alumni_update_form > section:nth-child(2) > div > div.col-md-4.profile-image-warp > div.col-md-6.update-btn-warp > button"));
		confirmProfilePicture.click();
		Thread.sleep(3000);
	}

	@Test(groups = "Present Address Country", enabled = false)
	public void presentAddressCountry() throws InterruptedException {

		WebElement presentAddressCountry = driver.findElement(By.cssSelector("#present_country"));
        //	presentAddressCountry.click();
		
		// Use Select class to choose Bangladesh
		Select selectText = new Select(presentAddressCountry);
		selectText.selectByVisibleText("Bangladesh");
		
		Thread.sleep(3000);

		String selectedOption = selectText.getFirstSelectedOption().getText();    	// Verify Selection (Optional)

		if (selectedOption.equals("Bangladesh")) {
			System.out.println("Country selected successfully!");
		} else {
			System.out.println("Selection failed!");
		}
	}

}





