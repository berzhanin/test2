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

public class MailRuPageTest {
    private WebDriver driver;
    private LoginIn mailRuLogin;
    private HomeMailPage mailRuContent;
    private SpamOrder mailRuSpamOrder;
    private SecondaryPage secondaryPage;
    private static final String LOGIN = "ddd.berzhanin";
    private static final String PASSWORD = "A1B23456";
    private int letterNumber = 0;
    private String[] addresseeList = new String[]{"test1@tralala.com", "test2@cicici.com"};
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

    @Test
    public void failLoginTest(){
        HomeMailPage loginIn = new HomeMailPage();
        loginIn.createDriver();
        loginIn.failLoginIn();
        loginIn.checkElement();
    }

    @Test
    public void trueLoginTest(){
        HomeMailPage loginIn = new HomeMailPage();
        loginIn.createDriver();
        loginIn.trueLoginIn();
        loginIn.checkElement();
    }

    @Test
    public void loginTest() {
        mailRuLogin = new LoginIn(driver);
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

    @Test
    public void addToSpamTest() {
        mailRuContent = new HomeMailPage(driver);
        mailRuContent.sendLetterToSpam(driver, letterNumber);
        Assert.assertTrue(mailRuContent.confirmLetterMovedToSpam(driver) > 0);
    }

    @Test
    public void moveFromSpam() {
        mailRuSpamOrder = new SpamOrder(driver);
        mailRuContent.goToSpam(driver);
        mailRuSpamOrder.restoreFromSpam(driver);
    }

    @Test
    public void composeLetter() {
        mailRuContent = new HomeMailPage(driver);
        secondaryPage = new SecondaryPage(driver);
        mailRuContent.composeLetter(driver);
        secondaryPage.fillAddressee(driver, addresseeList);
        secondaryPage.fillSubjectAndText(driver, subject, textToSend);
        secondaryPage.sendLetter(driver);
        secondaryPage.confirmLetterSent(driver);
    }

    @Test
    public void checkLetters() {
        mailRuContent = new HomeMailPage(driver);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(mailRuContent.checkInboxLetters(driver, lettersToCheck));
        mailRuContent.unCheckAll(driver);
        soft.assertTrue(mailRuContent.allUnchecked());
        soft.assertAll();
    }
}
