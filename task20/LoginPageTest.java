package tests.task20;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest
{
    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.enterLoginAndPass("ivanov.test1111.ivan@mail.ru", "A123456");
        loginPage.clickEnterButton();
        //wait(driver,10);
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
