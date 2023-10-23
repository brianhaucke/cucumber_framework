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
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	//Factory Design Pattern
	
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	
	
	@Then("user searched for same {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exits(String shortName) throws InterruptedException {

		switchToOffersPage();
		
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();

	}
	
	public void switchToOffersPage() //throws InterruptedException
	{
		//if switched to offers page-> skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
		//Thread.sleep(2000);

	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page() 
	{
		Assert.assertEquals(offerPageProductName, landingPageProductName); //testContextSetup.
	}

}
