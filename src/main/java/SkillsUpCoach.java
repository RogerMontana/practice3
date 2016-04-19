
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SkillsUpCoach extends BaseTest{

	private By ourTeam = By.linkText("Наша команда");
	private By nameFieldInsideCard = By.className("name");

	public void testThatBokhanIsPresened() throws Exception {
		goToCoachPage();
		String coach2 = "Евгения Бохан";
		assertTrue("person is not presented", getAllCoachNames().contains(coach2));
	}

	public void testThatGalkovskiyIsPresened() throws Exception {
		goToCoachPage();
		String coach3 =  "Александр Галковский";
		assertTrue("person is not presented", getAllCoachNames().contains(coach3));
	}

//	public void testThatKarpovIsPresentedWillFail() throws Exception {
//		goToCoachPage();
//		String coach1 = "Артем Карпов";
//		assertTrue("person is not presented", getAllCoachNames().contains(coach1));
//	}

	public void testThatKarpovIsPresented() throws Exception {
		goToCoachPage();
		String coach1 = "Артем Карпов";
		assertFalse("person is presented", getAllCoachNames().contains(coach1));
	}

	private void goToCoachPage() {
		driver.findElement(ourTeam).click();
	}

	private List<String> getAllCoachNames() {
		return driver.findElements(nameFieldInsideCard).stream().map(WebElement::getText).collect(Collectors.toList());
	}
}