package pageobjects_zaracoat_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage2 {
	public WebDriver driver;

	public CartPage2(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	public List<WebElement> getCartProductList() {
		return cartProducts;
	}

	public void getCartListByName(String CartProductName) throws InterruptedException {
		for (int i = 0; i < cartProducts.size(); i++) {
			String names = cartProducts.get(i).getText();
			System.out.println("List of products in cartpage:" + names);
			if (names.equalsIgnoreCase(CartProductName)) {
				// bynow button
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
				break;
			}

		}
	}

	public void getCartListByName1(String CartProductName) {
		for (int i = 0; i < cartProducts.size(); i++) {
			String names1 = cartProducts.get(i).getText();
			System.out.println("List of product in cartpage:" + names1);

			if (names1.equalsIgnoreCase(CartProductName)) {
				// bynow button
				WebElement checkout = driver.findElement(By.xpath("//button[text()='Checkout']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", checkout);

				break;
			}

		}
	}
}