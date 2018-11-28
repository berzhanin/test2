package task20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeLetterPage {

    @FindBy(xpath = ".//textarea[@data-original-name=\"To\"]")
    WebElement addresseeInputLine;

    @FindBy(xpath = ".//input[@name=\"Subject\"]")
    WebElement subjectLine;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[4]/div/div[2]/div[1]/div/span")
    WebElement sendLetterButton;

    @FindBy(xpath = "//*//*[@id=\"b-compose__sent\"]/div/div[1]/div/a[2]")
    WebElement goToInbox;


    public void fillAddressee(WebDriver driver, String[] addresseeList) {
        for (String addressee : addresseeList) {
            addresseeInputLine.sendKeys(addressee + "; ");
        }
    }

    public void fillSubjectAndText(WebDriver driver, String subject, String text) {
        subjectLine.sendKeys(subject + Keys.TAB + text);

    }

    public void sendLetter(WebDriver driver) {
        sendLetterButton.click();
    }

    public void confirmLetterSent(WebDriver driver) {
        goToInbox.click();
    }

    public ComposeLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
