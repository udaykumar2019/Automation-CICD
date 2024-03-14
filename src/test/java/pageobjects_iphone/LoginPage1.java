package pageobjects_iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.AbsractComponents;

public class LoginPage1 extends AbsractComponents {
	public WebDriver driver;

	public LoginPage1(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	private WebElement emailField;

	@FindBy(id = "userPassword")
	private WebElement psswordField;

	@FindBy(id = "login")
	private WebElement loginbuton;
	
	

	public void loginApplication(String email, String password) {
		emailField.sendKeys(email);
		psswordField.sendKeys(password);
		loginbuton.click();
		
	}
}
