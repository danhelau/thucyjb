package ta.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

@DefaultUrl("http://www.yandex.by")
public class NewLetterPage extends PageObject{
//	WebDriverWait wait;

//	public NewLetterPage(WebDriver driver) {
//		super(driver);
//		this.wait = new WebDriverWait(driver, 10);
//	}

	@FindBy(how = How.XPATH, using = "//tr[contains(@class, 'b-compose-head__field_to')]//input[1]")
	WebElement toField;

	@FindBy(how = How.XPATH, using = "//input[@id='compose-subj']")
	WebElement subjectField;

	@FindBy(how = How.XPATH, using = "//textarea[@id='compose-send']")
	WebElement bodyField;

	@FindBy(how = How.XPATH, using = "//a[@title='Черновики']")
	WebElement draftMenuItem;

	@FindBy(how = How.XPATH, using = "//button[@id='compose-submit']")
	WebElement sendBtn;

	@FindBy(how = How.XPATH, using = "//a[text()='Входящие']")
	WebElement inboxMenuItem;

	public void fillFields(String subject, String body, String recipient) {
		toField.sendKeys(recipient);
		subjectField.sendKeys(subject);
		bodyField.sendKeys(body);
	}

	public void waitForSaveAsDraft() {
		waitForPresenceOf("//span[contains(@class, 'b-compose-message__actions__helper_saved')]");
	}

	public void goToDrafts() {
		draftMenuItem.click();
	}

	public void verifyFields(String subject, String body) {
		waitFor(textToBePresentInElementValue(subjectField, subject));
		waitFor(textToBePresentInElementValue(bodyField, body));
	}

	public void submitLetter() {
		sendBtn.click();
	}

    public void letterSentWords(){
        ExpectedCondition<Boolean> ec = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getPageSource().contains("Письмо успешно отправлено.");
            }
        };
        waitFor(ec);
    }

	public void goToInboxPage() {
		inboxMenuItem.click();
	}

}
