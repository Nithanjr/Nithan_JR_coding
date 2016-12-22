package Selenium;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

//import org.testng.annotations.AfterTest;

public class Dailydata {
	
	WebDriver dr=new FirefoxDriver();
	
	@BeforeTest
	  public void login() {
		dr.get("http://20twenty.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("audiadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("Audi@#2020");
		dr.findElement(By.className("signin")).click();
		System.out.println("Login Successfull");
	  }
  
	@Test
  public void datacheck() throws InterruptedException {
		dr.get("http://20twenty.circussocial.com/site/stream");
		  Thread.sleep(5000);
		  //Click on filters
		  String xpath=".//*[@id='top']/div[5]/div[2]/div[1]/div[1]/div[1]/a";
		  dr.findElement(By.xpath(xpath)).click();
		  Thread.sleep(2000);
		  
		  //Select Facebook Platform 
		  List<WebElement> allPlatforms=dr.findElements(By.className("CategoryFilter"));	  
	  //System.out.println("Spans : "+allPlatforms.size());
		  for (WebElement CategoryFilter : allPlatforms)
		  {
		      String text = CategoryFilter.getText();
		      //System.out.println("TEXT : "+text);
		      if(text.equals("FORUMS"))
		      {
		    	
		    	  CategoryFilter.click();
		    	  break;
		      }
		      
		  }
		  
            Thread.sleep(3000);  
		    dr.findElement(By.xpath(".//*[@id='search_filters']/div/div[2]/div[2]/a[2]")).click();
		    Thread.sleep(2000);
		    //Duration of the post
		    String duration=dr.findElement(By.cssSelector("[id^='grid'] span.tltip-bottom.justnow.ng-binding")).getText();
		    System.out.println(duration);	
	}
}
 /* @AfterTest
  public void logout() {
	  
	  dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[2]/div[1]/span/i")).click();
	  dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div/ul/li[2]/a")).click();
		System.out.println("Logout Successfull");
  
  }*/


