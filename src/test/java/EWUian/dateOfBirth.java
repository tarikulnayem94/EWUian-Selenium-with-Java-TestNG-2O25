package EWUian;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dateOfBirth {

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
	public void chooseURL () {
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	}
	
	@Test
	public void chooseDateOfBirth () {
		
		driver.findElement(By.id("datepicker")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 2);    //  Selenium 3.x (Older Versions)
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));    // Selenium 4+ (Latest Versions)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-calendar")));
		
		String aMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(aMonth);
		
//		String aYear = driver.findElement(By.className("ui-datepicker-year")).getText();
//		
//		String aDay = driver.findElement(By.className("ui-datepicker-year")).getText();
//
//		while (!(aMonth.equals("October") && aYear.equals("1994") && aDay.equals("10"))) 
//		{
//		    driver.findElement(By.xpath("//a[@data-handler='next']")).click();
//		    aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
//		    aYear = driver.findElement(By.className("ui-datepicker-year")).getText();
//		    
//		    aDay = driver.findElement(By.className("ui-datepicker-year")).getText();
//		}
//
//		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='23']")).click();	
	}
	
	
	@Test
	public void chooseDateOfBirth2 () {
		
//		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
//
//		Calendar calendar = Calendar.getInstance();
//		String targetDate = "05-June-2021";
//		SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//		Date formattedTargetDate;
//		try {
//		    targetDateFormat.setLenient(false);
//		    formattedTargetDate = targetDateFormat.parse(targetDate);
//		    calendar.setTime(formattedTargetDate);
//
//		    int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
//		    int targetMonth = calendar.get(Calendar.MONTH);
//		    int targetYear = calendar.get(Calendar.YEAR);
//		}
//		
//		driver.findElement(By.id("second_date_picker")).click();
//		String actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); // june 2021
//		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
//
//		int actualMonth = calendar.get(Calendar.MONTH);
//		int actualYear = calendar.get(Calendar.YEAR);
//
//		while(targetMonth < actualMonth || targetYear < actualYear) {
//		    driver.findElement(By.className("ui-datepicker-prev")).click();
//		    actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); // june 2021
//		    calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
//
//		    int actualMonth = calendar.get(Calendar.MONTH);
//		    int actualYear = calendar.get(Calendar.YEAR);
		}
	
}






