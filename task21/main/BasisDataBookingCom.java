package task19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasisDataBookingCom {

    public static WebDriver driver;

    public WebDriver createDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public void findAndClick(String xpath) {

        driver.findElement(By.xpath(xpath)).click();
    }

    public String setDate(int dayToAdd) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DAY_OF_MONTH, dayToAdd);
        return sdf.format(calendar.getTime());
    }

    public int getPriceFromElement(String xpath) {
        return Integer.parseInt(driver.findElement(By.xpath(xpath)).getText().replaceAll("\\D", ""));
    }

    public int getPriceFromElement(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("\\D", ""));
    }

    public void waitForPopupVanish() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//*[@id=\"utag_59_iframe\"]"))));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(".//div[@class='sr-usp-overlay sr-usp-overlay--wide']"))));
    }
}
