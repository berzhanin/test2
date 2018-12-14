package webPageMailRu.classesForWebPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PostBoxWebPage extends HomeWebPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@data-name='link' and " +
            "not(ancestor::div[contains(@style, 'display: none;')])]")
    private List<WebElement> lettersList;

    @FindBy(xpath = "(//div[contains(@class,'checkbox__box') " +
            "and ancestor::div[@id='b-letters']" +
            "and not(ancestor::div[contains(@style, 'display: none;')])])")
    public List<WebElement> checkboxList;

    @FindBy(xpath = "(//div[contains(@class, 'b-checkbox__box')])[1]")
    public WebElement checkAll;

    @FindBy(xpath = "(//div[@data-name='spam'])[1]")
    public WebElement spamButton;

    @FindBy(xpath = "(//div[@data-name='noSpam'])[1]")
    public WebElement noSpamButton;

    @FindBy(xpath = "//div[@id='b-nav_folders']//span[text()='Входящие']")
    public WebElement incomingMailFolder;

    @FindBy(xpath = "//div[@id='b-nav_folders']//span[text()='Спам']")
    public WebElement spamFolder;

    @FindBy(xpath = "(//a[@data-name='compose'])[1]")
    private WebElement writeLetterButton;

    @FindBy(xpath = "(.//*[@data-original-name='To'])[1]")
    private WebElement letterRecipient;

    @FindBy(xpath = ".//*[@name='Subject']")
    private WebElement topicLetter;

    @FindBy(xpath = "//iframe")
    public WebElement iframeTextMessage;

    @FindBy(xpath = "(//div[@data-name='send'])[1]")
    public WebElement sendButton;

    @FindBy(xpath = ".//div[@class='message-sent__title']")
    private WebElement messageSentTitle;

    @FindBy(xpath = "//a[@data-name='link' " +
            "and not(ancestor::div[contains(@style, 'display: none;')])]" +
            "//div[contains(@class, 'b-flag_yes')]//b")
    public List<WebElement> flagsList;

    @FindBy(xpath = "(//div[contains(@class, 'b-dropdown_more')])[1]")
    public WebElement moreButtons;

    @FindBy(xpath = "(//a[@data-name='flag_no'])[1]")
    public WebElement removeFlags;

    @FindBy(xpath = "//div[@class='js-ok notify-message']")
    public WebElement notifyMessage;

    public PostBoxWebPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        driver = webdriver;
    }

    @Override
    public void checkPage() {
        assert lettersList.get(0).isDisplayed();
    }

    public void clickCheckbox(int index) {
        try {
            checkboxList.get(index).click();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clickSpamButton() {
        spamButton.click();
    }

    public void clickNoSpamButton() {
        noSpamButton.click();
    }

    public void moveLetterToSpam(int index) {
        clickCheckbox(index);
        clickSpamButton();
    }

    public void extractLetterFromSpam(int index) {
        spamFolder.click();
        clickCheckbox(index);
        clickNoSpamButton();
    }

    public void goToIncomingFolder() {
        setExplicitWait(driver, incomingMailFolder);
        incomingMailFolder.click();
    }

    public void goToSpam() {
        setExplicitWait(driver, spamFolder);
        spamFolder.click();
    }

    public void sendLetter(String receivers, String topic, String text) {
        writeLetterButton.click();
        letterRecipient.sendKeys(receivers);
        topicLetter.sendKeys(topic);
        enterMessage(text);
        sendButton.click();
    }

    public void enterMessage(String message) {
        driver.switchTo().frame(iframeTextMessage)
                .findElement(By.xpath("//body"))
                .sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public String getMessageSentTitle() {
        return messageSentTitle.getText();
    }

    public List<WebElement> getLettersList() {
        return lettersList;
    }

    public void markFlagOfFirst(int count) {
        List<WebElement> messages = lettersList;
        for (int row = 0; row < count; row++) {
            (messages.get(row)).findElement(By.xpath(".//div[@data-act='flag']")).click();
        }
    }

    public void removeAllFlag() {
        checkAll.click();
        moreButtons.click();
        removeFlags.click();
    }

    public String getNotifyMessage() {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        fluentWait.until(driver -> notifyMessage.getText().length() > 0);
        return notifyMessage.getText().trim();
    }

    public List<WebElement> getMarkTheFlag() {
        return flagsList;
    }


}

