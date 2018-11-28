package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MailRuTest {
    private WebDriver driver;
    private LoginPage mailRuLogin;
    private MailContentPage mailRuContent;
    private SpamPage mailRuSpamPage;
    private ComposeLetterPage composeLetterPage;
    private static final String LOGIN = "ddd.berzhanin";
    private static final String PASSWORD = "A1B23456";
    private int letterNumber = 0;
    private String[] addresseeList = new String[]{"test1@tralala.com", "test2@sisisi.com"};
    private String subject = "Test Subject";
    private String textToSend = "Test text";
    private int lettersToCheck = 3;
    private FluentWait wait;
    private int waitTimeOut = 5000;
    private int waitDuration = 250;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        driver.manage().window().maximize();
        wait = new FluentWait(driver);
        wait.withTimeout(waitTimeOut, TimeUnit.MILLISECONDS);
        wait.pollingEvery(waitDuration, TimeUnit.MILLISECONDS);
    }

    @Test//(priority = 0)
    public void loginTest() {
        mailRuLogin = new LoginPage(driver);
        mailRuLogin.enterCredeintials(LOGIN, PASSWORD);
        mailRuLogin.pushSubmitButton();
        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return mailRuLogin.confirmLogin().equals(LOGIN + "@mail.ru");
            }
        };
        wait.until(function);
        Assert.assertEquals(mailRuLogin.confirmLogin(), LOGIN + "@mail.ru");
    }

    @Test//(priority = 1)
    public void addToSpamTest() {
        mailRuContent = new MailContentPage(driver);
        mailRuContent.sendLetterToSpam(driver, letterNumber);
        Assert.assertTrue(mailRuContent.confirmLetterMovedToSpam(driver) > 0);
    }

    @Test//(priority = 2)
    public void moveFromSpam() {
        mailRuSpamPage = new SpamPage(driver);
        mailRuContent.goToSpam(driver);
        mailRuSpamPage.restoreFromSpam(driver);
    }

    @Test//(priority = 3)
    public void composeLetter() {
        mailRuContent = new MailContentPage(driver);
        composeLetterPage = new ComposeLetterPage(driver);
        mailRuContent.composeLetter(driver);
        composeLetterPage.fillAddressee(driver, addresseeList);
        composeLetterPage.fillSubjectAndText(driver, subject, textToSend);
        composeLetterPage.sendLetter(driver);
        composeLetterPage.confirmLetterSent(driver);
    }

    @Test//(priority = 4)
    public void checkLetters() {
        mailRuContent = new MailContentPage(driver);  // COMMENT IT
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(mailRuContent.checkInboxLetters(driver, lettersToCheck));
        mailRuContent.unCheckAll(driver);
        soft.assertTrue(mailRuContent.allUnchecked());
        soft.assertAll();
    }
}
