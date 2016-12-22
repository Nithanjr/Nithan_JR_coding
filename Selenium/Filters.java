package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Filters {
	
	WebDriver dr=new FirefoxDriver();
	
	@BeforeMethod
	  public void login() {
		dr.get("http://20twenty.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("ncadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("Nithan@#2020");
		dr.findElement(By.className("signin")).click();
		
	  }
	
  @Test
  public void customfilters() throws InterruptedException {
	  dr.get("http://20twenty.circussocial.com/site/stream");
	  Thread.sleep(5000);
	  String xpath=".//*[@id='top']/div[5]/div[2]/div[1]/div[1]/div[1]/a";
	  dr.findElement(By.xpath(xpath)).click();
	  Thread.sleep(2000);
	  
	/*  //Location
	 WebElement loc1=dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[5]/div/div/ul/li[7]/div/label"));
	if(loc1.isSelected()==false)
	{
		loc1.click();
	}
	 Thread.sleep(2000);
	 WebElement loc2=dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[5]/div/div/ul/li[3]/div/label"));
	 loc2.click();
	 Thread.sleep(3000);
	 
	 //Platform
	 dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[6]/div/div/ul/li[3]/div/label")).click();
	 dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[6]/div/div/ul/li[6]/div/label")).click();
	 Thread.sleep(3000);
	 
	 //Duration
	 dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[7]/div/div/ul/li[2]/div/label")).click();*/
	 //Custom duration
	 dr.findElement(By.xpath(".//*[@id='datepicker_from']")).click();
	 //start date
	 dr.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a")).click();
	 Thread.sleep(4000);
	 //End Date
	 dr.findElement(By.xpath(".//*[@id='datepicker_to']")).click();
	 
	 dr.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a")).click();
	 Thread.sleep(2000);
	 
	 dr.findElement(By.xpath(".//*[@id='search_filters']/div/div/div[12]/div[2]/a[2]")).click();
	 Thread.sleep(4000);
	 
	   //Validation
	 String Actualtext=dr.findElement(By.className("post_count")).getText();
	 System.out.println(Actualtext);
	 Assert.assertEquals(Actualtext, "50727 posts");
  }
  

  @AfterMethod
  public void logout() throws InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[2]/div[1]/span/i")).click();
	  Thread.sleep(2000);
	  dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div/ul/li[2]/a")).click();
  }

}
