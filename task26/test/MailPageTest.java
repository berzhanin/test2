import java.util.concurrent.TimeUnit;

import task26.Requests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task26.LoginPage;
import task26.MailPage;
import task26.Config;

public class MailPageTest extends Config {
    private MailPage mailPage;
    private LoginPage loginPage;
    private static final int TIMEOUT_FOR_IMPLICITLY = 10;
    private static final int TIMEOUT_FOR_LOAD = 30;

    @BeforeClass
    public void beforeClass() {
        Requests request = new Requests();
        String login = request.getValueParam("login");
        String password = request.getValueParam("password");
        driver.manage().timeouts().implicitlyWait(TIMEOUT_FOR_IMPLICITLY, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_FOR_LOAD, TimeUnit.SECONDS);
        driver.get(URL);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        loginPage.enterLoginAndPass(login, password);
        loginPage.clickEnterButton();
    }

    //  перемещение письма в Спам
    @Test(priority = 1)
    public void moveToSpamTest() {
        mailPage.moveLetterToSpam(0);
        String expectedTest = "Письмо перемещено в папку «Спам». Отменить";
        String actualText = mailPage.getNotifyMessage();
        mailPage.goToSpam();
        Assert.assertEquals(actualText, expectedTest);
    }

    //  извлечение письма из Спама
    @Test(priority = 2)
    public void extractFromSpamTest() {
        mailPage.goToSpam();
        mailPage.extractLetterFromSpam(0);
        String expectedTest = "Письмо перемещено в папку «Входящие»";
        System.out.println("text = "+mailPage.getNotifyMessage());
        String actualText = mailPage.getNotifyMessage();
        mailPage.goToIncomingFolder();
        Assert.assertEquals(actualText, expectedTest);
    }

    //   отправка сообщения группе пользователей
    @Test(priority = 5)
    public void sendMessToGroupTest() {
        String recipients = "my_test_email2018@mail.ru, TestTest@mail.ru";
        String topic = "TestTopic";
        String text = "Text for text letter.";
        mailPage.sentLetter(recipients, topic, text);
        String expectedMess = "Ваше письмо отправлено. Перейти во Входящие";
        Assert.assertEquals(expectedMess, mailPage.getMessageSentTitle());
    }

    //   пометить 3 письма флажком
    @Test(priority = 3)
    public void mark3LettersFlagTest() {
        mailPage.goToIncomingFolder();
        int numberMarked = 3;
        mailPage.markFlagOfFirst(numberMarked);
        Assert.assertEquals(mailPage.flagsList.size(), numberMarked);
    }

    //   снять отметку флажка со всех писем
    @Test(priority = 4)
    public void deselectAllFlagsTest() {
        mailPage.goToIncomingFolder();
        mailPage.removeAllFlag();
        Assert.assertFalse(mailPage.getMarkTheFlag().size() > 0);
    }

}