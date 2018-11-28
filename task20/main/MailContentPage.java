package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MailContentPage {

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[3]")
    private WebElement addToSpamButton;

    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[4]/a")
    private WebElement goToSpamLink;

    @FindAll({
            @FindBy(xpath = ".//*[@data-bem='b-datalist__item']")})
    private List<WebElement> inboxLetters;

    @FindAll({
            @FindBy(xpath = ".//*/div/a/div/div/div[@class='b-checkbox__box']")})
    private List<WebElement> inboxLettersCheckbox;

    @FindAll({
            @FindBy(xpath = ".//*[@class=\"b-datalist__item js-datalist-item b-datalist__item_selected\"]")})
    private List<WebElement> CheckboxChecked;

    @FindAll({
            @FindBy(xpath = ".//div[@class=\"b-spam-confirm\"]")})
    public List<WebElement> addToSpamConfirmationDialogue;

    @FindBy(xpath = ".//button[@data-id=\"approve\"]")
    public WebElement addToSpamConfirmationDialogueConfirmButton;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")})
    public List<WebElement> movedToSpamConfirmed;

    @FindBy(xpath = ".//a[@data-name=\"compose\"]")
    WebElement composeLetterButton;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div[2]")
    WebElement checkUncheckAll;


    public MailContentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendLetterToSpam(WebDriver driver, int letterNumber) {
        Actions action = new Actions(driver);
        action.contextClick(inboxLetters.get(letterNumber)).perform();
        addToSpamButton.click();
        if (addToSpamConfirmationDialogue.size() > 0) {
            addToSpamConfirmationDialogueConfirmButton.click();
        }
    }

    public int confirmLetterMovedToSpam(WebDriver driver) {

        return movedToSpamConfirmed.size();
    }

    public void goToSpam(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(goToSpamLink));
        goToSpamLink.click();

    }

    public void composeLetter(WebDriver driver) {
        composeLetterButton.click();
    }

    public boolean checkInboxLetters(WebDriver driver, int numberOfLettersToCheck) {
        int numberOfChecks = 0;
        for (int i = 0; i < inboxLettersCheckbox.size(); i++) {
            if (i < numberOfLettersToCheck) {
                inboxLettersCheckbox.get(i).click();
                numberOfChecks++;
            } else {
                break;
            }
        }
        return CheckboxChecked.size() == numberOfChecks;
    }

    public boolean allUnchecked() {
        return CheckboxChecked.size() == 0;
    }

    public void unCheckAll(WebDriver driver) {
        checkUncheckAll.click();
    }
}
