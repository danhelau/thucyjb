package ta.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("http://www.yandex.by")
public class InboxPage extends PageObject {

	@FindBy(how = How.XPATH, using = "//a[@href='#compose']")
	WebElement composeButton;

	@FindBy(how = How.XPATH, using = "//a/span[@class='header-user-name js-header-user-name']")
	WebElement exitLink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Выход') and @data-action='common.clck']")
	WebElement exitItem;

	public void createNewLetter() {
		composeButton.click();
	}
	
	public void verifyLetterPresents(String letterSubject){
		waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//*[text()='" + letterSubject + "']")));
	}
	
	public void logout(){
		exitLink.click();
		exitItem.click();
	}
	
	
}