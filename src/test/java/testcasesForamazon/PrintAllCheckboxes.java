package testcasesForamazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PrintAllCheckboxes {

	WebDriver driver;
	String Browser = "edge";
	SoftAssert st = new SoftAssert();
	@Test
	public void printTextOfCheckboxes() {
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get("https://www.amazon.com/");// open url
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on Don't change
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]")).click();
		// click on todaysdeal
		driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]")).click();
		List<WebElement> chkboxes = driver.findElements(By.xpath("//li[@class='CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49']"));
	
		//Print all checkboxes text
		for(WebElement chk : chkboxes)
		{
			System.out.println(	chk.getText());
		}

	}

}
