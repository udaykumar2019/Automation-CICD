package pageobjects_zaracoat_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2  {
	public WebDriver driver;

	public LoginPage2(WebDriver driver) {
		
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
