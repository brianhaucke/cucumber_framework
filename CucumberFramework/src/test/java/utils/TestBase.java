package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager()
	{
		if(driver == null)
		{
		System.setProperty("webdriver.chrome.driver", "/Users/brian/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();  //driver gets the life
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		return driver;
	}

}
