package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects_iphone.CartPage;
import pageobjects_iphone.HomePage;
import pageobjects_iphone.LoginPage1;
import pageobjects_iphone.PlaceOrderPage;
import pageobjects_zaracoat_3.CartPage2;
import pageobjects_zaracoat_3.ConfirmationPage2;
import pageobjects_zaracoat_3.HomePage2;
import pageobjects_zaracoat_3.LoginPage2;
import pageobjects_zaracoat_3.PlaceOrderPage2;
import resources.Base;

public class EcartTest_ZaraCoat_3 extends Base {
	WebDriver driver;
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		LoginPage2 loginpage = new LoginPage2(driver);
		loginpage.loginApplication("nethra@gmail.com", "Amma@333");
		
		String Productname = "ZARA COAT 3";
		HomePage homepage = new HomePage(driver);
		List<WebElement> products = homepage.getProductList();
		homepage.getProductByName(Productname);
		Thread.sleep(2000);
		homepage.goToCartButton();
		
		CartPage2 cartpage = new CartPage2(driver);
		cartpage.getCartProductList();
		cartpage.getCartListByName(Productname);
		cartpage.getCartListByName1(Productname);
		Thread.sleep(2000);
		
	
		String Productname1 = "ADIDAS ORIGINAL";
		HomePage2 homepage2 = new HomePage2(driver);
		List<WebElement> products1 = homepage2.getProductList1();
		homepage2.getProductByName1(Productname1);
		Thread.sleep(2000);
		homepage.goToCartButton();
		
		CartPage2 cartpage1 = new CartPage2(driver);
		Thread.sleep(2000);
		cartpage1.getCartListByName1(Productname);
		Thread.sleep(2000);
		PlaceOrderPage2 placeorder = new PlaceOrderPage2(driver);
		placeorder.selectCountryTextFiled().click();
		placeorder.selectCountryTextFiled().sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> countrylist = placeorder.getCountryList();
		placeorder.getCountryListByName();
		
		WebElement submit = placeorder.placeOrderButton();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);
		
		ConfirmationPage2 confirmpage = new ConfirmationPage2(driver);
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
