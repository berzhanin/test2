package task19;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BookingComTest {
    BookingCom AUT = new BookingCom();

    @Test(enabled = true)
    public void Test_1() {
        WebDriver driver = AUT.createDriver();
        AUT.setBasicConditions();
        Assert.assertTrue(AUT.isHotels());
        Assert.assertTrue(AUT.searchGoodPrice());
        driver.quit();
    }

    @Test(enabled = true)
    public void Test_2() {
        WebDriver driver = AUT.createDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        AUT.setBasicConditions();
        Assert.assertTrue(AUT.searchGoodPrice());
    }

    @Test(enabled = true)
    public void Test_3() {
        String expectedErrorMessage = "Введите номер действительной кредитной карты";
        Assert.assertEquals(AUT.AutoBookHotel(), expectedErrorMessage);
    }


}
