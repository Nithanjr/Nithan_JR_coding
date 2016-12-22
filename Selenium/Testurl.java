package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testurl {

	public static void main(String[] args) {
		
		WebDriver dr=new FirefoxDriver();
		dr.get("http://google.com");
		

	}

}
