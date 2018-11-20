package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	


	WebDriver driver;

	@FindBy(xpath = "//*[@id=\\\"wsb-element-00000000-0000-0000-0000-000450914886\\\"]/div/h1")
	WebElement homePage;

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement menuPage;
	
	public String readHome() {

		return homePage.getText();

	}

	public String readMenu() {
		return menuPage.getText();
	}
	
	public void clickMenu() {
		menuPage.click();
	}

}
