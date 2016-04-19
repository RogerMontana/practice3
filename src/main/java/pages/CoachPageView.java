package pages;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class CoachPageView {

	private WebDriver driver;

	private static String baseUrl = "http://skillsup.ua";

	private By ourTeam = By.linkText("Наша команда");

	private By nameFieldInsideCard = By.className("name");

	public CoachPageView(WebDriver driver) {
		this.driver = driver;
		driver.get(baseUrl);
		PageFactory.initElements(driver, this);
	}

	public void goToCoachPage() {
		driver.findElement(ourTeam).click();
	}

	public void checkThatPersonIsPresented(String person) {
		assertTrue(person + " person is not presented", getAllCoachNames().contains(person));
	}

	public void checkThatPersonIsNotPresented(String person) {
		assertFalse(person + " person is presented", getAllCoachNames().contains(person));
	}

	private List<String> getAllCoachNames() {
		return driver.findElements(nameFieldInsideCard).stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
