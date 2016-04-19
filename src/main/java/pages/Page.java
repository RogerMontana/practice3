package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Page {

	protected static String baseUrl = "http://skillsup.ua";

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		driver.get(baseUrl);
		PageFactory.initElements(driver, this);
	}
}
