package task19;
/*
1. Париж, текущая дата + 3 дня, на 7 дней. 2 взрослых. Отфильтровать самые дешевые,
проверить, что такие отели есть. Выбрать с самым высоким рейтингом и проверить, что
цена не превышает заданный диапазон.
2. Париж, текущая дата + 3 дня, на 7 дней. 4 взрослых, 2 номера. Выбрать самый дешевый из
самых дорогих, и проверить, что цена не ниже заданного диапазона.
3. На отеле из предыдущего кейса забронировать номер, ввести все поля, ввести неверный
номер карты и проверить, что появилось сообщение об ошибке. Номер карты – 4242 4242
4242 4242, остальные данные любые.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;


public class BookingCom extends BasisDataBookingCom{

    int priceForNight;

    public void setBasicConditions() {
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();
        WebElement enterCity = driver.findElement(By.xpath(".//input[@id='ss']"));
        enterCity.sendKeys("Paris");
        findAndClick(".//div[@class='xp__dates-inner xp__dates__checkin']");
        findAndClick(".//td[@data-date='" + setDate(3) + "']");
        findAndClick(".//td[@data-date='" + setDate(3 + 7) + "']");
    }

    public boolean isHotels() {
        findAndClick(".//span[text()='Проверить цены']");
        findAndClick("//*[@id=\"filter_price\"]/div[2]/a[1]/div/span[1]");
        priceForNight = getPriceFromElement("//*[@id=\"filter_price\"]/div[2]/a[1]/div/span[1]");
        ArrayList<WebElement> separatorList = new ArrayList<>(driver.findElements(By.xpath(".//div[@class=\"sr_item sr_separator u-font-weight-bold sr_separator_first sr_autoextend_divider sr_autoextend_divider__container\"]")));
        if (separatorList.size() < 1) {
            return true;
        }
        WebElement firstHotel = driver.findElement(By.xpath("(.//a[@class='hotel_name_link url'])[1]"));
        return firstHotel.getLocation().getY() < separatorList.get(0).getLocation().getY();
    }

    public boolean SearchHotelByRating() {
        findAndClick(".//a[@data-category=\"review_score_and_price\"]");
        waitForPopupVanish();
        findAndClick("(.//a[@class='hotel_name_link url'])[1]");
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return (getPriceFromElement("(.//span[@class=\"hprt-price-price-standard jq_tooltip \"])[1]") / 7) <= priceForNight;
    }

    public boolean searchGoodPrice() {
        findAndClick(".//span[@class=\"xp__guests__count\"]");

        ArrayList<WebElement> selectors = new ArrayList<>(driver.findElements(By.xpath(".//select[@id='no_rooms']")));
        if (selectors.size() > 0) {
            Select roomsNumber = new Select(selectors.get(0));
            roomsNumber.selectByIndex(2 - 1);
        } else {
            while (Integer.parseInt(driver.findElement(
                    By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/span")).getText()) < 2) {
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/button[2]")).click();
            }
        }

        selectors = new ArrayList<>(driver.findElements(By.xpath("//select[@id=\"group_adults\"]")));
        if (selectors.size() > 0) {
            Select roomsNumber = new Select(selectors.get(0));
            roomsNumber.selectByIndex(4 - 1);
        } else {
            while (Integer.parseInt(driver.findElement(
                    By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/span")).getText()) < 4) {
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/button[2]")).click();
            }
        }
        findAndClick(".//span[text()='Проверить цены']");
        ArrayList<WebElement> priceOptions = new ArrayList<>(driver.findElements(By.xpath("//*[@id='filter_price']/div[2]/a/div/span[contains(text(),'BYN')]")));
        priceForNight = getPriceFromElement(priceOptions.get(priceOptions.size() - 1));
        priceOptions.get(priceOptions.size() - 1).click();
        waitForPopupVanish();
        findAndClick(".//a[@data-category=\"price\"]");
        waitForPopupVanish();
        findAndClick("(.//a[@class='hotel_name_link url'])[1]");
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return ((getPriceFromElement("(.//span[@class=\"hprt-price-price-standard jq_tooltip \"])[1]") / 7)) * 2 >= priceForNight;
    }

    public String AutoBookHotel() {
        Select roomNumbers = new Select(driver.findElement(By.xpath("(.//select[@class=\"hprt-nos-select\"])[1]")));
        roomNumbers.selectByIndex((2 - 1));
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(".//div[@data-component=\"hotel/new-rooms-table/reservation-cta\"]"))));
        findAndClick(".//div[@data-component=\"hotel/new-rooms-table/reservation-cta\"]");
        WebElement names = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        names.sendKeys("Pan" + Keys.TAB + "Peter" + Keys.TAB + "testdata@gmail.com" + Keys.TAB + "testdata@gmail.com");
        WebElement notes = driver.findElement(By.xpath("//*[@id=\"remarks\"]"));
        notes.sendKeys("Please do not worry! I am a fabulous character.");
        findAndClick("//button[contains(@name,'book')]");

        ArrayList<WebElement> addressData = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"address1\"]")));
        if (addressData.size() != 0) {

            addressData.get(0).sendKeys("Fantasie,1" + Keys.TAB + "Dream" + Keys.TAB + Keys.TAB + "0123210");
        }
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phone.sendKeys("17622568");

        Select creditCardType = new Select(driver.findElement(By.xpath("//*[@id=\"cc_type\"]")));
        creditCardType.selectByIndex(2);
        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"cc_number\"]"));
        cardNumber.sendKeys("2424242424242424");
        Select cardValid = new Select(driver.findElement(By.xpath("//*[@id=\"cc_month\"]")));
        cardValid.selectByIndex(10);
        WebElement cvc = driver.findElement(By.xpath("//*[@id=\"cc_cvc\"]"));
        cvc.sendKeys("777");
        WebElement cardMessage = driver.findElement(By.xpath("//*[@id=\"bp_form_cc_number_msg\"]"));
        return cardMessage.getText().trim();
    }
}
