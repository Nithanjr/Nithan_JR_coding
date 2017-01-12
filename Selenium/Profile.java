package Selenium;

//import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Profile {
	
	WebDriver dr=new FirefoxDriver();
	
	@BeforeMethod
	  public void login() throws InterruptedException
	{
		dr.get("http://20twentycasstage.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("singaporetourismboardadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("s@#2020");
		dr.findElement(By.id("loginBtn")).click();
		Thread.sleep(8000);
		
	  }
	
     @Test
       public void Reports() throws InterruptedException 
       
     {
	  
	  dr.get("http://20twentycasstage.circussocial.com/site/profile");
	  Thread.sleep(3000);
	  JavascriptExecutor jse1 = (JavascriptExecutor)dr;
	  jse1.executeScript("window.scrollBy(0,500)", "");
	  Thread.sleep(2000);
	  dr.findElement(By.id("name")).sendKeys("Test Report");
	  dr.findElement(By.id("report_email")).clear();
	  dr.findElement(By.id("report_email")).sendKeys("nithan.jr@circussocial.com");
	  Thread.sleep(3000);
	  //Select Frequency
	 /*dr.findElement(By.xpath(".//*[@id='frequency_chosen']/a/div/b")).click();
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='frequency_chosen']/div/div[1]/input")).sendKeys("Daily Summary");
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='frequency_chosen']/div/div[1]/input")).sendKeys(Keys.RETURN);
	  Thread.sleep(4000);
	  //Select Time
	  dr.findElement(By.xpath(".//*[@id='set_time_val_chosen']/a/div/b")).click();
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='set_time_val_chosen']/div/div[1]/input")).sendKeys("10:00:00");
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='set_time_val_chosen']/div/div[1]/input")).sendKeys(Keys.RETURN);
	  Thread.sleep(3000);
	  //Select Location(Social)
	  dr.findElement(By.xpath(".//*[@id='locationfill']")).click();
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='loca_dropdown']/div[1]/input")).sendKeys("Singapore");
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(".//*[@id='loca_dropdown']/div[2]/ul/li[2]")).click();
	  //Select Location(News)
	  dr.findElement(By.xpath(".//*[@id='location_news_fill']")).click();
	  Thread.sleep(2000);
	  dr.findElement(By.xpath(".//*[@id='news_loca_dropdown']/div[1]/input")).sendKeys("ALL");
	  Thread.sleep(2000);
	  dr.findElement(By.xpath(".//*[@id='news_loca_dropdown']/div[2]/ul/li[1]")).click();*/
	  
	  //Select Platform
	  dr.findElement(By.xpath(".//*[@id='report_platform']")).click();
	  Thread.sleep(2000);
	  dr.findElement(By.xpath(".//*[@id='platform_topic_dropdown']/div/div/ul/li[2]/label")).click();
	  
	  /*List<WebElement> selectPlatform=dr.findElements(By.className("topic_main"));
	  
	  for (WebElement topic_main : selectPlatform)
	  {
	      String text = topic_main.getText();
	      
	      System.out.println("TEXT : "+text);
	      if(text.equals("Blog"))
	      {
	    	  topic_main.click();
	       break;
	      }
      
      }*/
	  
	  //Select News Topics
	  dr.findElement(By.xpath(".//*[@id='report_news_topic']")).click();
	  Thread.sleep(2000);
	  dr.findElement(By.xpath(".//*[@id='un_topic_dropdown']/div/div/ul/li[1]/label")).click();
	  
	  
	  
   }
     
     
  @AfterMethod
  public void afterMethod() {
  }

}
