package com.infosys.testing.TeaTesting;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.CheckOut;
import PageFactory.HomePage;
import PageFactory.MenuPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.support.PageFactory;

public class TeaTestingSteps {

	public ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated Testing\\BasicReport.html",
			true);;
	public ExtentTest test;
	public ExtentTest test2;

	private WebDriver driver;

	@Given("^the correct web address$")
	public void the_correct_web_address() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.practiceselenium.com/welcome.html");

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {

		test = report.startTest("Verify Menu-Page");
		

		HomePage menuPage = PageFactory.initElements(driver, HomePage.class);
		menuPage.readMenu();
		menuPage.clickMenu();
		
		test.log(LogStatus.INFO, "Check Clicked");

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {

		MenuPage listTea = PageFactory.initElements(driver, MenuPage.class);
		if (listTea.readTea().equals("Red Tea")) {
			test.log(LogStatus.PASS, "verify correct web-page");

		} else {
			test.log(LogStatus.FAIL, "verify correct web-page");
		}
		assertEquals("Red Tea", listTea.readTea());
		

		report.endTest(test);
		report.flush();

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {

		test2 = report.startTest("Verify CheckOut-Page");
		

		MenuPage checkOut = PageFactory.initElements(driver, MenuPage.class);
		checkOut.buyRedTea();
		
	//	test.log(LogStatus.INFO, "Check Red Tea");

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {

		CheckOut checkoutPage = PageFactory.initElements(driver, CheckOut.class);
		if (checkoutPage.readCredit().equals("Pay with Credit Card or Log In")) {
			test2.log(LogStatus.PASS, "verify correct web-page");

		} else {
			test2.log(LogStatus.FAIL, "verify correct web-page");
		}
		assertEquals("Pay with Credit Card or Log In", checkoutPage.readCredit());
		
		report.endTest(test2);
		report.flush();

	}

	@After
	public void after() {
		driver.quit();

	
	}

}
