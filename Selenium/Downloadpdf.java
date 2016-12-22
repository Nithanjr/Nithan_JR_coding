package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Downloadpdf {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr=new FirefoxDriver();
		dr.get("http://20twenty.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("ncadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("Nithan@#2020");
		dr.findElement(By.className("signin")).click();
        dr.get("http://20twenty.circussocial.com/site/stream");
        Thread.sleep(3000);
        dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[1]/div[3]/a/span[1]")).click();
        dr.findElement(By.xpath(".//*[@id='top']/div[5]/div[2]/div[1]/div[1]/div[3]/div/ul/li[3]/a")).click();
	}

}
