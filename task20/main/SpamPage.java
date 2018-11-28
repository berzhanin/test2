package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage {

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[1]/div/a/div[1]")
    private WebElement firstLetterInSpamCheckBox;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[3]/div")
    private WebElement notASpamButton;

    public void restoreFromSpam(WebDriver driver) {
        firstLetterInSpamCheckBox.click();
        notASpamButton.click();
    }

    public SpamPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
