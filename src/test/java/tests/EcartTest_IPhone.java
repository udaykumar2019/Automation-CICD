package tests;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects_iphone.CartPage;
import pageobjects_iphone.ConfirmationPage;
import pageobjects_iphone.HomePage;
import pageobjects_iphone.LoginPage1;
import pageobjects_iphone.PlaceOrderPage;
import resources.Base;

public class EcartTest_IPhone extends Base {
	WebDriver driver;

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		LoginPage1 loginpage = new LoginPage1(driver);
		loginpage.loginApplication("udaykumar@gmail.com", "Amma@123");

		String Productname = "IPHONE 13 PRO";
		HomePage homepage = new HomePage(driver);
		Thread.sleep(2000);
		List<WebElement> products = homepage.getProductList();
		Thread.sleep(2000);
		homepage.getProductByName(Productname);
		Thread.sleep(2000);
		homepage.goToCartButton();
		Thread.sleep(2000);

		CartPage cartpage = new CartPage(driver);
		Thread.sleep(2000);
		cartpage.getCartProductList();
		cartpage.getCartListByName(Productname);
		Thread.sleep(2000);

		PlaceOrderPage placeorder = new PlaceOrderPage(driver);
		placeorder.selectCountryTextFiled().click();
		placeorder.selectCountryTextFiled().sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> countrylist = placeorder.getCountryList();
		placeorder.getCountryListByName();
		Thread.sleep(2000);
		WebElement submit = placeorder.placeOrderButton();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);

		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		Thread.sleep(2000);
		WebElement signeoutbutton = confirmpage.getConfirmationMessage();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signeoutbutton);
		Thread.sleep(2000);
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void closure() {
		driver.close();
	}

}
