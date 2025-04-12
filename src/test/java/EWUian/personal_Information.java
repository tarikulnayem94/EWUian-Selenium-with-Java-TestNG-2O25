package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class personal_Information {

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

	@Test(groups = { "personal_Information" })
	public void personalInformation() throws InterruptedException {

//		WebElement gender = driver.findElement(By.cssSelector("#gender"));
//		gender.click();
		Thread.sleep(2000);

		WebElement choosegender = driver.findElement(By.cssSelector("#gender > option:nth-child(2)"));
		Select select = new Select(choosegender);
		select.selectByVisibleText("Male");

		WebElement socialLink = driver.findElement(By.xpath("//textarea[@id='additional_social_media_url']"));
		socialLink.sendKeys("https://www.facebook.com/tarikul.nayem.8");

		WebElement nID = driver.findElement(By.xpath("//input[@id='nid_birth_certificate']"));
		nID.sendKeys("98765434567");
		WebElement schoolName = driver.findElement(By.cssSelector("#ssc_school_name"));
		schoolName.sendKeys("98765434567");

	}

	@Test(groups = { "personal_Information" })
	public void personalInformation2() throws InterruptedException {
		WebElement contactNumber = driver.findElement(By.id("contact_number"));
		contactNumber.sendKeys("01712575851");

		WebElement selectDept = driver.findElement(By.id("//select[@id='department_short_code']"));
		Select selectDpt = new Select(selectDept);
		selectDpt.selectByVisibleText("Computer Science & Engineering");
		Thread.sleep(5000);

		WebElement socialElement = driver.findElement(By.xpath("//select[@id='social_media_type']"));
		Select selectMedia = new Select(socialElement);
		selectMedia.selectByVisibleText("Facebook");
	}

	@Test(groups = { "personal_Information" })
	public void personalInformation3() throws InterruptedException {
		WebElement hsc = driver.findElement(By.xpath("//input[@id='hsc_college_name']"));
		hsc.sendKeys("gsh college");

		WebElement presentAddress = driver.findElement(By.xpath("//input[@id='present_address']"));
		presentAddress.sendKeys("Banasree, rampura, dhaka");

		WebElement googleDriveLink = driver.findElement(By.xpath("//input[@id='google_drive_link']"));
		googleDriveLink.sendKeys("https://drive.google.com/file/d/1bLqXIohM_HdfELjAe5_Jw78ZfAvEQlCX/view?usp=sharing");

		WebElement signature = driver.findElement(By.xpath("//input[@id='signature_image']"));
		String filePath = "D:\\Nayem\\Avater\\signeture.dr.png";
		signature.sendKeys(filePath);
		Thread.sleep(2000);
	}  

	@Test(groups = { "personal_Information" })
	public void inportdateOfBirth() throws InterruptedException {

	    WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id='date_of_birth']"));
		Select selectMedia = new Select(dateOfBirth);
		selectMedia.selectByVisibleText("Facebook");

	    driver.findElement(By.id("date_of_birth")).click(); // Change if needed
        driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("1995");

        driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("August");
        driver.findElement(By.xpath("//td/a[text()='15']")).click();
	}

}
