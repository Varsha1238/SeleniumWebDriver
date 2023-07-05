package testcasesForamazon;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Flipkart {

	WebDriver driver;
	String Browser = "edge";
	SoftAssert st = new SoftAssert();
	@Test
	public void test() throws InterruptedException {
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get("https://www.msn.com/en-in");// open url
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		//Click on filpkart button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"body > fluent-design-system-provider > entry-point\").shadowRoot.querySelector(\"#entry-point-hp-wc-root-wrapper > div.content-container > div.me-stripe-container > me-stripe\").shadowRoot.querySelector(\"div > msft-horizontal-card-slider > me-stripe-tile:nth-child(1)\").shadowRoot.querySelector(\"div > a > div.me-stripe-title-container > div\").click();");
		//Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parent = it.next();
		String child = it.next();
		//Switch to diff window
		driver.switchTo().window(child);
		Thread.sleep(5000);
		//Enter text to filpkart window
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("mobiles");
		driver.close();
		driver.switchTo().window(parent);
		//clickon find tutor
		Thread.sleep(5000);
		js.executeScript("document.querySelector(\"body > fluent-design-system-provider > entry-point\").shadowRoot.querySelector(\"#entry-point-hp-wc-root-wrapper > div.content-container > div.me-stripe-container > me-stripe\").shadowRoot.querySelector(\"div > msft-horizontal-card-slider > me-stripe-tile:nth-child(3)\").shadowRoot.querySelector(\"div > a > div.me-stripe-title-container > div > div\").click();");
	}

}
