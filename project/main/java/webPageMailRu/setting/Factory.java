package webPageMailRu.setting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Factory {

    private Factory() {
    }

    public static WebDriver getDriver(String driverType) {
        if ("chrome".equals( driverType)) {
            return new ChromeDriver();
        }
        return new FirefoxDriver();
    }
}
