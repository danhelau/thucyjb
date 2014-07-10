package ta.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://mail.yandex.by/neo2/#draft")
public class DraftPage extends PageObject {

    public void letterExists(String letterSubject) {
//        waitForPresenceOf("//a//*[text()='" + letterSubject + "']");
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath("//a//*[text()='" + letterSubject + "']")));
    }

    public void openLetter(String letterSubject) {
        WebElement draftLetterLink = getDriver().findElement(By.xpath("//a//*[text()='" + letterSubject + "']"));

        waitFor(ExpectedConditions.elementToBeClickable(draftLetterLink));
        draftLetterLink.click();
    }

}
