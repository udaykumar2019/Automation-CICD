package pageobjects_zaracoat_3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage2 {
	public WebDriver driver;
	public ConfirmationPage2(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="(//button[@class='btn btn-custom'])[4]")
	WebElement signoutbutton;
	
	public WebElement getConfirmationMessage() {
		
		return signoutbutton;
	}
}
