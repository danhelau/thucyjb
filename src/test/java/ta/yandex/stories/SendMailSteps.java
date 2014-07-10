package ta.yandex.stories;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ta.steps.SourceSteps;

public class SendMailSteps {

    @Steps
    SourceSteps userStep;

    @Given("user with credentials '$login' and '$pwd' is logged in")
    public void givenUserWithCredentialsLoggedIn(String login, String pwd) {
        userStep.isStartPageOpened();
        userStep.userLoggedIn(login, pwd);
    }

    @When("user creates letter with $subject and $body $to")
    public void whenUserCreatesLetter(String subject, String body, String to) {
        userStep.userCreatesNewLetter();
        userStep.userFillsLetterContent(subject, body, to);
    }

    @When("sends the letter")
    public void sendsTheLetter() {
        userStep.sendLetter();
    }

    @Then("letter is sent")
    public void thenLetterIsSent() {
        userStep.letterIsSent();
    }

}
