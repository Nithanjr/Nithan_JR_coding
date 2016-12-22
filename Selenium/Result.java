package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Result {

	public static void main(String[] args) throws InterruptedException

	{
		WebDriver dr = new FirefoxDriver();
		dr.get("http://20twenty.circussocial.com/site/login");
		dr.findElement(By.id("LoginForm_username")).sendKeys("audiadmin");
		dr.findElement(By.id("LoginForm_password")).sendKeys("Audi@#2020");
		dr.findElement(By.className("signin")).click();
		System.out.println("Login Successuful");
		
		dr.get("http://20twenty.circussocial.com/site/stream");
		Thread.sleep(5000);

		// Click on filters
		String xpath = ".//*[@id='top']/div[5]/div[2]/div[1]/div[1]/div[1]/a";
		dr.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);

		List<WebElement> allPlatforms = dr.findElements(By.className("CategoryFilter"));
		// System.out.println("Spans : "+allPlatforms.size());
		
		for (WebElement CategoryFilter : allPlatforms) 
		{
			String text = CategoryFilter.getText();
			// System.out.println("TEXT : "+text);

			// Select Facebook Platform
			if (text.equals("FACEBOOK")) 
			{
				
				CategoryFilter.click();
                 Thread.sleep(6000);
				String xpath1 = ".//*[@id='search_filters']/div/div[2]/div[2]/a[2]";
				dr.findElement(By.xpath(xpath1)).click();
				
                Thread.sleep(5000);
                
				String facebookDuration = dr.findElement(By.cssSelector("[id^='grid'] span.tltip-bottom.justnow.ng-binding")).getText();
				System.out.println(facebookDuration);

				try {
					File src = new File("/home/ramadmin/Desktop/Nithan.xls");
					FileInputStream fis = new FileInputStream(src);
					@SuppressWarnings("resource")
					HSSFWorkbook wb = new HSSFWorkbook(fis);
					HSSFSheet sh = wb.getSheetAt(0);
					sh.createRow(0).createCell(0).setCellValue("Client");
					sh.getRow(0).createCell(1).setCellValue("Facebook");
					// sh.getRow(0).createCell(2).setCellValue("Facebook");
					sh.createRow(1).createCell(0).setCellValue("Citibank");
					sh.getRow(1).createCell(1).setCellValue(facebookDuration);
					// sh.getRow(1).createCell(1).setCellValue(fbDuration);

					FileOutputStream fos = new FileOutputStream(
							"/home/ramadmin/Desktop/Nithan.xls");
					wb.write(fos);
					fos.close();

				}

				catch (Exception e)

				{

					System.out.println(e.getMessage());

				}
				Thread.sleep(2000);
				// Uncheck Facebook
 
				dr.findElement(By.xpath(xpath)).click();
                
				//reset filter
				Thread.sleep(2000);
				dr.findElement(By.xpath(".//*[@id='search_filters']/div/div[2]/div[2]/a[1]")).click();
				
				System.out.println("Reset Filter");
				/*if (text.equals("FACEBOOK")) 
				{

					CategoryFilter.click();

					dr.findElement(By.xpath(xpath1)).click();

				}*/
				
			}
/*
			// Instagram

				 if (text.equals("INSTAGRAM"))

			{

				CategoryFilter.click();

				String xpath1 = ".//*[@id='search_filters']/div/div/div[12]/div[2]/a[2]";
				dr.findElement(By.xpath(xpath1)).click();

				String instagramDuration = dr.findElement(By.cssSelector("[id^='grid'] span.tltip-bottom.justnow.ng-binding")).getText();
				System.out.println(instagramDuration);

				try {
					File src = new File("/home/ramadmin/Desktop/Nithan.xls");
					FileInputStream fis = new FileInputStream(src);
					@SuppressWarnings("resource")
					HSSFWorkbook wb = new HSSFWorkbook(fis);
					HSSFSheet sh = wb.getSheetAt(0);
					// sh.createRow(0).createCell(0).setCellValue("Client");
					sh.getRow(0).createCell(2).setCellValue("INSTAGRAM");
					// sh.getRow(0).createCell(2).setCellValue("Facebook");
					// sh.createRow(1).createCell(0).setCellValue("Citibank");
					sh.getRow(1).createCell(2).setCellValue(instagramDuration);
					// sh.getRow(1).createCell(1).setCellValue(fbDuration);

					FileOutputStream fos = new FileOutputStream(
							"/home/ramadmin/Desktop/Nithan.xls");
					wb.write(fos);
					fos.close();

				}

				catch (Exception e)

				{
					System.out.println(e.getMessage());

				}
				
				Thread.sleep(2000);

				// Uncheck Instagram
				dr.findElement(By.xpath(xpath)).click();
				
				if (text.equals("INSTAGRAM")) {

					CategoryFilter.click();

					dr.findElement(By.xpath(xpath1)).click();
				}
				

			}

			// TWITTER
             if (text.equals("TWITTER"))

			{

				CategoryFilter.click();

				String xpath1 = ".//*[@id='search_filters']/div/div/div[12]/div[2]/a[2]";
				dr.findElement(By.xpath(xpath1)).click();

				String twitterDuration = dr.findElement(By.cssSelector("[id^='grid'] span.tltip-bottom.justnow.ng-binding")).getText();
				System.out.println(twitterDuration);

				try {
					File src = new File("/home/ramadmin/Desktop/Nithan.xls");
					FileInputStream fis = new FileInputStream(src);
					@SuppressWarnings("resource")
					HSSFWorkbook wb = new HSSFWorkbook(fis);
					HSSFSheet sh = wb.getSheetAt(0);
					// sh.createRow(0).createCell(0).setCellValue("Client");
					sh.getRow(0).createCell(3).setCellValue("TWITTER");
					// sh.getRow(0).createCell(2).setCellValue("Facebook");
					// sh.createRow(1).createCell(0).setCellValue("Citibank");
					sh.getRow(1).createCell(3).setCellValue(twitterDuration);
					// sh.getRow(1).createCell(1).setCellValue(fbDuration);

					FileOutputStream fos = new FileOutputStream(
							"/home/ramadmin/Desktop/Nithan.xls");
					wb.write(fos);
					fos.close();

				}

				catch (Exception e)

				{
					System.out.println(e.getMessage());

				}
				Thread.sleep(2000);

				// Uncheck Twitter
				dr.findElement(By.xpath(xpath)).click();

				if (text.equals("TWITTER")) {

					CategoryFilter.click();

					dr.findElement(By.xpath(xpath1)).click();

				}
				
			}*/
		

		}

	}
}