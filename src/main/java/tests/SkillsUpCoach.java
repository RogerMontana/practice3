package tests;

import org.junit.Test;
import pages.CoachPageView;

public class SkillsUpCoach extends BaseTest {
	private CoachPageView coachPageView;

	@Test
	public void checkThatBokhanIsPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertTrue(coachPageView.checkThatPersonIsPresented("Евгения Бохан"));
	}

	@Test
	public void checkThatGalkovskiyIsPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertTrue(coachPageView.checkThatPersonIsPresented("Александр Галковский"));
	}

	@Test
	public void checkThatKarpovIsNotPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertFalse(coachPageView.checkThatPersonIsPresented("Артем Карпов"));
	}
}