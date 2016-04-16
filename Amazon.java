package Automation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon {

	private static final String ERROR_MESSAGE = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";

	@Test
	public void test() throws InterruptedException {
		// Initializing firefox driver
		WebDriver dr = new FirefoxDriver();

		// Get the amazon website
		dr.manage().window().maximize();
		dr.get("http://www.amazon.in/");
		Thread.sleep(3000);

		// mouse hover on main menu "shop by category"
		Actions action = new Actions(dr);
		WebElement mainMenu = dr.findElement(By.id("nav-link-shopall"));
		action.moveToElement(mainMenu).build().perform();
		Thread.sleep(1000);

		// mouse hover on sub menu "Mobile and Tablets"
		WebElement subMenu = dr.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[5]/span"));
		action.moveToElement(subMenu).build().perform();
		Thread.sleep(2000);

		// select Android mobiles
		dr.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[5]/div[1]/div/a[3]/span")).click();
		// page scroll
		JavascriptExecutor jse = (JavascriptExecutor) dr;
		jse.executeScript("window.scrollBy(0,200)", "");

		// filter by Motorola
		List<WebElement> refinementLinks = dr.findElements(By.className("refinementLink"));
		for (WebElement refinementLink : refinementLinks) {
			String text = refinementLink.getText();
			if (text.equals("Motorola")) {
				refinementLink.click();
				break;
			}
		}

		// sort by low to high
		dr.findElement(By.xpath(".//*[@id='sort']")).click();
		Select select = new Select(dr.findElement(By.id("sort")));
		select.selectByIndex(1);
		Thread.sleep(2000);
		// scroll page
		JavascriptExecutor jse1 = (JavascriptExecutor) dr;
		jse1.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(2000);

		// select the last item on the first page
		dr.findElement(By.cssSelector("ul.s-result-list li.s-result-item:last-child a")).click();

		// switch to new window
		Set<String> allWindows = dr.getWindowHandles();
		for (String currentWindow : allWindows) {
			dr.switchTo().window(currentWindow);
			Thread.sleep(2000);
		}
		dr.manage().window().maximize();

		// in the item detail page - enter pin code - 700037
		dr.findElement(By.xpath(".//*[@id='ddmSelectedAddressText']/b")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("ddmZipCodeInput")).sendKeys("700037");
		Thread.sleep(2000);
		dr.findElement(By.xpath(".//*[@id='ddmZipCodeUpdateBtn']/span/input")).click();

		// Add to cart
		dr.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();

		// proceed to checkout
		dr.findElement(By.xpath(".//*[@id='hlb-ptc-btn-native']")).click();

		// type in careers@floh.in as username and a random password. Then,
		// login
		dr.findElement(By.id("ap_email")).sendKeys("careers@floh.in");
		dr.findElement(By.id("ap_password")).sendKeys("Career@#2016");
		dr.findElement(By.id("signInSubmit")).click();

		// validate error on the screen
		String errorMsg = dr.findElement(By.className("a-list-item")).getText();
		
		Assert.assertEquals(errorMsg, ERROR_MESSAGE);
	}
}
