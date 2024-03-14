package pageobjects_iphone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.AbsractComponents;

public class ConfirmationPage  {

	public ConfirmationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="(//button[@class='btn btn-custom'])[4]")
	WebElement signoutbutton;
	
	public WebElement getConfirmationMessage() {
		return signoutbutton;
	}
	
	
}
