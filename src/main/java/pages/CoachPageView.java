package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class CoachPageView {

	private WebDriver driver;

	private static String pageUrl = "http://skillsup.ua";

	private By ourTeam = By.linkText("Наша команда");

	private By nameFieldInsideCard = By.className("name");

	public CoachPageView(WebDriver driver) {
		this.driver = driver;
		driver.get(pageUrl);
		PageFactory.initElements(driver, this);
	}

	public void goToCoachPage() {
		driver.findElement(ourTeam).click();
	}

	public Boolean checkThatPersonIsPresented(String person) {
		return getAllCoachNames().contains(person);
	}
	
	private List<String> getAllCoachNames() {
		return driver.findElements(nameFieldInsideCard).stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
