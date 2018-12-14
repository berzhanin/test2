package webPageMailRu.setting;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Config {

    private FileInputStream fis;
    private Properties property = new Properties();

    protected static String DRIVER_TYPE;
    protected static String url;
    protected static String login;
    protected static String password;
    protected WebDriver driver;

    public Config() {
        try {
            System.out.println("setConfiguration.");
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            url = property.getProperty("URL");
            DRIVER_TYPE = property.getProperty("browserType");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        Requests requests = Requests.getInstance();
        login = requests.getValueParam("login");
        password = requests.getValueParam("password");
    }

    public void initDriver() {
        System.out.println("initDriver.");
        driver = Factory.getDriver(DRIVER_TYPE);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    public void closeDriver() {
        System.out.println("closeDriver.");
        driver.close();
    }
}
