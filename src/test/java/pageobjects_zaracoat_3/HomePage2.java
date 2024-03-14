package pageobjects_zaracoat_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.AbsractComponents;

public class HomePage2 extends AbsractComponents {
	public WebDriver driver;

	public HomePage2(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']/div/div/h5/b")
	List<WebElement> products;

	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']/div/div/h5/b")
	List<WebElement> products1;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By waitProductsBy = By.cssSelector(".mb-3");
	By waitToastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElemenToAppear(waitProductsBy);
		waitForElemenToAppear(waitToastMessage);
		waitForElementToDissAppear(spinner);
		return products;
	}

	public List<WebElement> getProductList1() {

		return products1;
	}

	public void getProductByName(String Productname) {
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			System.out.println("List of products in homepage:" + name);
			if (name.contains(Productname)) {
				// add to cart
				driver.findElements(By.xpath("//div[@class=\"card-body\"]//button[@class=\"btn w-10 rounded\"]")).get(i)
						.click();
				break;
			}
			waitForElemenToAppear(waitToastMessage);
			waitForElementToDissAppear(spinner);
		}

	}

	public void getProductByName1(String Productname1) throws InterruptedException {
		for (int i = 0; i < products1.size(); i++) {
			String name = products1.get(i).getText();
			System.out.println("List of products in home page:" + name);
			if (name.contains(Productname1)) {
				Thread.sleep(2000);
				// add to cart
				driver.findElements(By.xpath("//div[@class=\"card-body\"]//button[@class=\"btn w-10 rounded\"]")).get(i)
						.click();
				break;
			}

		}

	}

	public void goToCartButton() {
		cartButton.click();

	}

}