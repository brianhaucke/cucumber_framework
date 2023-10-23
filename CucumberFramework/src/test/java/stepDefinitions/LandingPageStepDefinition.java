package stepDefinitions;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	
	//Single Responsibility Principle = Classes should only have one responsibility
	//Loosely coupled = sharing the info from one class to another with dependency injection
	//Less long term maintenance
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
	    
		System.setProperty("webdriver.chrome.driver", "/Users/brian/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		testContextSetup.driver = new ChromeDriver();  //driver gets the life
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//System.out.println("User navigated to Greenkart Landing Page");
				
	}
	@When("user searched with short name {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		LandingPage landingPage = new LandingPage(testContextSetup.driver);//testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000); // Wait for 2 seconds 
		landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		//testContextSetup.
		//System.out.println(landingPageProductName +" is extracted from Home page");
		
		
		
		
	}
	
	


}
