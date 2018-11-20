package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut {
	

		WebDriver driver;

		@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong")
		WebElement creditPage;

		public String readCredit() {

			return creditPage.getText();

		}

}
