package tests;

import pages.CoachPageView;

public class SkillsUpCoach extends BaseTest {
	private CoachPageView coachPageView;

	public void testThatBokhanIsPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertTrue(coachPageView.checkThatPersonIsPresented("Евгения Бохан"));
	}

	public void testThatGalkovskiyIsPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertTrue(coachPageView.checkThatPersonIsPresented("Александр Галковский"));
	}

	public void testThatKarpovIsNotPresented() throws Exception {
		coachPageView = new CoachPageView(driver);
		coachPageView.goToCoachPage();
		assertFalse(coachPageView.checkThatPersonIsPresented("Артем Карпов"));
	}
}