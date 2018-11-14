package tests.task18;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class BookingComTest {

    WebDriver driver;
    String url = "https://www.booking.com";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    void setDate(LocalDate inDate, LocalDate outDate) {
        WebElement calendar = driver.findElement(By.xpath("(//button[@aria-label='Открыть календарь'])[2]"));
        calendar.click();
        driver.findElement(By.xpath("//td[contains(@class,'bui-calendar__date bui-calendar__date--today')]")).click();
        driver.findElement(By.xpath("//td[@data-date='2018-11-16']")).click();
    }

    void goMoscow() {
        driver.get(url);
        String city = "Москва";
        WebElement enterCity = driver.findElement(By
                .xpath("//input[@placeholder='Куда вы хотите поехать?']"));
        enterCity.sendKeys(city);
        setDate(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        WebElement checkPriceButton = driver.findElement(By
                .xpath("//button[contains(.,'Проверить цены')]"));
        checkPriceButton.click();
    }

    // Ввести в поиск "Москва", выбрать для проживания 2 гостей и 1 номер.
    // Проверить, что в Москве есть отели на введенные даты.
    @Test
    public void findHotelsInMoscowTest() {
        goMoscow();
        List<WebElement> hotelList = driver.findElements(By
                .xpath("//span[@xpath='1']"));
        Assert.assertTrue(hotelList.size() > 0,
                "Не едим в Москву =( ");
    }

    // Ввести"Москва" 2 гостей  1 номер фильтр макс рейтинг
    // Открыть первым отель проверить его рейтинг >= 9.
    @Test(priority = 1)
    public void findBestHotelInMoscowTest() {
        goMoscow();
        WebElement sortHotel = driver.findElement(By
                .xpath("//a[contains(.,'Оценка по отзывам и цена')]"));
        sortHotel.click();
        WebElement firstHotel = driver.findElement(By
                .xpath("(//a[@class='hotel_name_link url'])[1]"));
        firstHotel.click();
        driver.getWindowHandle();
        driver.switchTo().window(driver.getWindowHandle());
        Double rating = Double.valueOf(driver.findElement(By
                .xpath("(//div[@class='bui-review-score__badge'])[1]")).getText());
        System.out.println(rating);
        Assert.assertTrue(rating >=9,
                "Отель с низким рейтингом");
    }
}








