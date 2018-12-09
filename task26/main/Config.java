package task26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Config {

    private FileInputStream fis;
    private Properties property = new Properties();
    protected static String URL;
    private static String LOGIN;
    private static String PASSWORD;

    protected WebDriver driver;
    private Requests request;

    public Config() {
        try {
            System.out.println("setConfiguration.\n");
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            URL = property.getProperty("URL");
            LOGIN = property.getProperty("login");
            PASSWORD = property.getProperty("password");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    @BeforeSuite
    public void initDriver() {
        System.out.println("createDatabase and initDriver.");
        request = new Requests();
        request.createDatabase();
        request.fillDatabase("login", LOGIN);
        request.fillDatabase("password", PASSWORD);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeDriver() {
        System.out.println("dropDatabase and closeDriver.");
        request.dropDatabase();
        driver.close();
    }
}