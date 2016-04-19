
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SkillsUpCoach extends BaseTest{

	private By ourTeam = By.linkText("Наша команда");
	private By nameFieldInsideCard = By.className("name");

	public void testThatBokhanIsPresented() throws Exception {
		goToCoachPage();
		checkThatPersonIsPresented("Евгения Бохан");
	}

	public void testThatGalkovskiyIsPresented() throws Exception {
		goToCoachPage();
		checkThatPersonIsPresented("Александр Галковский");
	}

	public void testThatKarpovIsPresented() throws Exception {
		goToCoachPage();
		checkThatPersonIsNotPresented("Артем Карпов");
	}

	private void goToCoachPage() {
		driver.findElement(ourTeam).click();
	}

	private void checkThatPersonIsPresented(String person) {
		assertTrue(person + " person is not presented", getAllCoachNames().contains(person));
	}

	private void checkThatPersonIsNotPresented(String person) {
		assertFalse(person + " person is presented", getAllCoachNames().contains(person));
	}

	private List<String> getAllCoachNames() {
		return driver.findElements(nameFieldInsideCard).stream().map(WebElement::getText).collect(Collectors.toList());
	}
}