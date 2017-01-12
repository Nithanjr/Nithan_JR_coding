package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UserAccount {
	
	WebDriver dr=new FirefoxDriver();
	
	@BeforeTest
	  public void login() throws InterruptedException 
	{
		
		final String URL= "http://20twentycasstage.circussocial.com/";
		
		dr.get("http://20twentycasstage.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("singaporetourismboardadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("s@#2020");
		dr.findElement(By.id("loginBtn")).click();
		Thread.sleep(5000);
		String indexpage=dr.getCurrentUrl();
		Assert.assertEquals(indexpage,URL);
		System.out.println("Login Successfull");
	 }

	
 /* @Test(priority=1)
  public void useraccountcreation() throws InterruptedException 
  
  {
	   
	  final String ExpectedValidationMSG= "Account Creation Successfull";
	  dr.get("20twentycasstage.circussocial.com/setting/user_management");
	  Thread.sleep(4000);
	  dr.findElement(By.name("user_name")).sendKeys("Nithan");
	  dr.findElement(By.name("username")).sendKeys("nithantest123");
	  dr.findElement(By.name("email")).sendKeys("nithan34@gmail.com");
	  Thread.sleep(5000);
	  dr.findElement(By.xpath(".//*[@id='adminsettingsblock']/div/div[1]/div/div/div/div/div[7]/div/a/span")).click();
	  Thread.sleep(3000);
	  String actualValidationMSG=dr.findElement(By.xpath(".//*[@id='alertify-logs']/article")).getText();
	  Assert.assertEquals(actualValidationMSG,ExpectedValidationMSG);
	  System.out.println(actualValidationMSG);
	  
  }*/
  
  @Test(priority=2)
  public void createnewteam() throws InterruptedException
  {
	  //final String ExpectedValidationMSG="Team Created Successfull";
	  dr.get("20twentycasstage.circussocial.com/setting/user_management");
	  Thread.sleep(2000);
	 //Scroll page
	 JavascriptExecutor jse1 = (JavascriptExecutor)dr;
	 jse1.executeScript("window.scrollBy(0,800)", "");
	 Thread.sleep(1000);
	 dr.findElement(By.id("team_name")).sendKeys("Team2017");
	 Thread.sleep(2000);
	 
	 //Autosuggestion
	 WebElement teamname=dr.findElement(By.xpath(".//*[@id='adminsettingsblock']/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div/span/input[2]"));
	 teamname.clear();
	 teamname.sendKeys("m");
	 Thread.sleep(8000);
	 
     
      
	  List<WebElement> selectTeamUser=dr.findElements(By.className("mainMenu"));
	
	  
	  for (WebElement mainMenu : selectTeamUser)
	  {
		
	      String text = mainMenu.getText();
	      System.out.println("TEXT : "+text);
	      if(text.equals("Mridul_1111"))
	      {
	    	  mainMenu.click();
	       break;
	      }
	 
	  }
	 /*Actions action=new Actions(dr);
	 action.moveToElement(teamname.findElement(By.className("tt-dropdown-menu")).sendKeys("Nithan")).click().build().perform();
     Thread.sleep(1000);
     //dr.findElement(By.xpath("span/div[2]/p")).click();
     Thread.sleep(3000);*/
	
	 
	 
     dr.findElement(By.xpath(".//*[@id='adminsettingsblock']/div/div[2]/div/div/div/div/div[1]/div/div[2]/a[2]/span")).click();
     Thread.sleep(6000);
	 }
     
     //String actualValidationMSG=dr.findElement(By.xpath(".//*[@id='alertify-logs']/article")).getText();
     //Assert.assertEquals(actualValidationMSG,ExpectedValidationMSG);
     //System.out.println(actualValidationMSG);
  
  
  
  
  
  @AfterTest
  public void logout() {
	  
	  
  }

}
