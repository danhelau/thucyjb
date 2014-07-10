package ta.pages;

import net.thucydides.core.annotations.DefaultUrl;
//import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DefaultUrl("http://www.yandex.by")
public class LoginPage extends PageObject {

    @FindBy(how = How.XPATH, using = "//input[@name='login']")
    WebElementFacade loginInput;

    @FindBy(how = How.NAME, using = "passwd")
    WebElementFacade passwd;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    WebElementFacade loginButtton;

    public void login(String login, String password) {
        loginInput.clear();
        loginInput.sendKeys(login);

        passwd.clear();
        passwd.sendKeys(password);

        loginButtton = element("//input[@type='submit']");   //hack
        loginButtton.click();
    }
}
