package pageobjects_iphone;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	 public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	public List<WebElement> getCartProductList() {
		return cartProducts;
	}
	public void getCartListByName(String CartProductName) {
		for(int i=0; i<cartProducts.size(); i++) {
			String names = cartProducts.get(i).getText();
			System.out.println("List of products in cartpage:"+names);
			if(names.equalsIgnoreCase(CartProductName)) {
				//bynow button
			driver.findElement(By.xpath("//div[@class='cartSection removeWrap']/button[1]")).click();
			break;
			}
			
			}
	}
	
}
