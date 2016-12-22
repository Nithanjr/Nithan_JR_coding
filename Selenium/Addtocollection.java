package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Addtocollection {
	
	WebDriver dr=new FirefoxDriver();
	
	@BeforeMethod
	  public void beforeMethod() {
		dr.get("http://20twenty.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("ncadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("Nithan@#2020");
		dr.findElement(By.className("signin")).click();
		   }

  @Test
  public void collection() throws InterruptedException {
	  
	  dr.get("http://20twenty.circussocial.com/site/stream");
	  Thread.sleep(5000);
	  //dr.findElement(By.cssSelector(".#grid li:nth-child(0).collection")).click();
	  Actions action = new Actions(dr);
	  WebElement mainContent = dr.findElement(By.className("tooltipPallet_bg"));
	   action.moveToElement(mainContent).build().perform();
	   Thread.sleep(1000);
	   //first collection post
      dr.findElement(By.className("collection")).click();
      Thread.sleep(2000);
      dr.findElement(By.id("newcollection")).sendKeys("New Collection");
      Thread.sleep(2000);
      dr.findElement(By.xpath(".//*[@id='accessTypeDropdown_chosen']/a/span")).click();
      Thread.sleep(2000);
      dr.findElement(By.xpath(".//*[@id='accessTypeDropdown_chosen']/div/ul/li[2]")).click();
      //Thread.sleep(2000);
      dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[4]/div/div[3]/a[2]")).click();
      Thread.sleep(1000);
      String Actualtext=dr.findElement(By.xpath(".//*[@id='alertify-logs']/article")).getAttribute("alertify-logs");
      System.out.println(Actualtext);
	  
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  
  }

}
