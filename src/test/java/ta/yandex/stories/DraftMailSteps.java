package ta.yandex.stories;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ta.steps.SourceSteps;

public class DraftMailSteps {

    @Steps
    SourceSteps userStep;

    private Long uniqueId;

    @Given("user with credentials '$login' and '$pwd' is logged in")
    public void givenUserWithCredentialsLoggedIn(String login, String pwd) {
        userStep.isStartPageOpened();
        userStep.userLoggedIn(login, pwd);
    }

    @When("user creates letter with $subject and $body $to")
    public void whenUserCreatesLetter(String subject, String body, String to) {
        userStep.userCreatesNewLetter();
        uniqueId = System.currentTimeMillis();
        userStep.userFillsLetterContent(subject + uniqueId, body, to);
    }

    @Then("letter with $subject and $body $to is saved in drafts")
    public void thenLetterWithSubject(String subject, String body, String recipient) {
        userStep.userWaitsForNewDraft();
        userStep.isDraftPageOpened();
        userStep.userChecksDraftsForLetter(subject + uniqueId);
    }

}
