package HomeWork22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;

public class BookingPage {
    private WebDriver driver;
    private static final String BOOKING_URL = "https://www.booking.com";

    @FindBy(xpath = ".//input[@id='ss']")
    private WebElement enterCity;

    @FindBy(xpath = ".//div[@class='xp__dates-inner xp__dates__checkin']")
    private WebElement calendar;
    @FindBy(xpath = ".//span[@class= 'xp__guests__count']")
    private WebElement informationOfGuest;

    @FindBy(xpath = "(.//span[@data-bui-ref= 'input-stepper-value'])[1]")
    private WebElement roomsCount;

    @FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-add-button'])[1]")
    private WebElement roomsPlus;

    @FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-subtract-button'])[1]")
    private WebElement roomsMinus;

    @FindBy(xpath = ".//select[@id='no_rooms']")
    private List<WebElement> selectForRooms;

    @FindBy(xpath = "(.//span[@data-bui-ref= 'input-stepper-value'])[2]")
    private WebElement adultsCount;

    @FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-add-button'])[2]")
    private WebElement adultsPlus;

    @FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-subtract-button'])[2]")
    private WebElement adultsMinus;

    @FindBy(xpath = ".//select[@name='group_adults']")
    private List<WebElement> selectForAdults;

    @FindBy(xpath = ".//span[text()='Проверить цены']")
    private WebElement checkPriceButton;

    @FindBy(xpath = ".//a[@data-category='price']")
    private WebElement sortByPrice;

    @FindBy(xpath = ".//a[@data-category='review_score_and_price']")
    private WebElement sortByRating;

    @FindBy(xpath = "(.//a[@class='hotel_name_link url'])") //".//span[@class[contains(.,'sr-hotel__name')]]")
    private List<WebElement> hotelList;

    @FindBy(xpath = ".//div[@class ='sr--usp-overlay sr--usp-overlay--wide']")
    private List<WebElement> waitMe;

    @FindBy(xpath = ".//div[@class='bui-review-score__badge']")
    private WebElement hotelRating;

    public BookingPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        driver = webdriver;
    }

    public String getBookingUrl() {
        return BOOKING_URL;
    }

    public List<WebElement> getHotelList() {
        return hotelList;
    }

    public void setInitialData(String city, LocalDate inDate, LocalDate outDate, int countRooms, int countAdults) {
        enterCity.clear();
        enterCity.sendKeys(city);
        setDate(inDate, outDate);
        informationOfGuest.click();
        setCountRooms(countRooms);
        setCountAdults(countAdults);
        checkPriceButton.click();
    }

    private void setDate(LocalDate inDate, LocalDate outDate) {
        calendar.click();
        driver.findElement(By.xpath("//table//td[@data-date='" + inDate.toString() + "']")).click();
        driver.findElement(By.xpath("//table//td[@data-date='" + outDate.toString() + "']")).click();
    }

    private void setCountRooms(int countRooms) {
        if (selectForRooms.size() > 0) {
            new Select(selectForRooms.get(0))
                    .selectByIndex(countRooms - 1);
        } else {
            if (countRooms > Integer.parseInt(roomsCount.getText())) {
                while (countRooms != Integer.parseInt(roomsCount.getText()))
                    roomsPlus.click();
            }
            if (countRooms < Integer.parseInt(roomsCount.getText())) {
                while (countRooms != Integer.parseInt(roomsCount.getText()))
                    roomsMinus.click();
            }
        }
    }

    private void setCountAdults(int countAdults) {
        if (selectForAdults.size() > 0) {
            new Select(selectForAdults.get(0))
                    .selectByIndex(countAdults - 1);
        } else {
            if (countAdults > Integer.parseInt(adultsCount.getText())) {
                while (countAdults != Integer.parseInt(adultsCount.getText()))
                    adultsPlus.click();
            }
            if (countAdults < Integer.parseInt(adultsCount.getText())) {
                while (countAdults != Integer.parseInt(adultsCount.getText()))
                    adultsMinus.click();
            }
        }
    }

    public void sortByPrice() {
        sortByPrice.click();
        waitingDownload(waitMe);
    }

    public void sortByRating() {
        sortByRating.click();
        waitingDownload(waitMe);
    }

    private void waitingDownload(List<WebElement> waitSmth) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .invisibilityOfAllElements(waitSmth));
    }

    public Double getHotelRating() {
        return Double.parseDouble(hotelRating.getText());

    }
}