package pageobjects_iphone;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	public WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	private WebElement selectCountryTextFiled;
	
	@FindBy(css = ".action__submit")
	private WebElement placeOrderButton;
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')]/span")
	List<WebElement> country;
	
	public List<WebElement> getCountryList() {
		return country;
	}
	public void getCountryListByName() throws InterruptedException {
		for(int i=0;i<country.size();i++) {
			String countryname=country.get(i).getText();
			if(countryname.equalsIgnoreCase("India")) {
				
				Thread.sleep(2000);
				driver.findElements(By.xpath("//button[contains(@class,'ta-item')]/span")).get(i).click();
				break;
			}
		}
	}
	
	public WebElement selectCountryTextFiled() {
		return selectCountryTextFiled;
		
	}
	public WebElement placeOrderButton() {
		return placeOrderButton;
	}
}
