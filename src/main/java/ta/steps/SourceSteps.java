package ta.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import ta.pages.DraftPage;
import ta.pages.InboxPage;
import ta.pages.LoginPage;
import ta.pages.NewLetterPage;
import net.thucydides.core.steps.ScenarioSteps;

public class SourceSteps extends ScenarioSteps {

    LoginPage loginPage;
    InboxPage inboxPage;
    DraftPage draftPage;
    NewLetterPage newLetterPage;

    @Step
    public void isStartPageOpened() {
        loginPage.open();
    }

    @Step
    public void userLoggedIn(String login, String pass) {
        loginPage.login(login, pass);
    }

    @Step
    public void userCreatesNewLetter() {
        inboxPage.createNewLetter();
    }

    @Step
    public void userFillsLetterContent(String subject, String body, String recipient) {
        newLetterPage.fillFields(subject, body, recipient);
    }

    @Step
    public void userWaitsForNewDraft() {
        newLetterPage.waitForSaveAsDraft();
    }

    @Step
    public void isDraftPageOpened() {
        draftPage.open();
    }

    @Step
    public void userChecksDraftsForLetter(String name) {
        draftPage.letterExists(name);
    }

    @Step
    public void sendLetter() {
        newLetterPage.submitLetter();
    }

    @Step
    public void letterIsSent() {
        newLetterPage.letterSentWords();
    }
}
