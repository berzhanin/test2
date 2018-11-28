import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingPageSteps {
    private WebDriver driver;
    private BookingPage bookingPage;

    public BookingPageSteps()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        bookingPage = new BookingPage(driver);
    }

    @Given("^I am on main booking page$")
    public void loadMainPage(){
        driver.get(bookingPage.getBookingUrl());
    }

    @When("^I perform search hotel in  \"([^\"]*)\" with room \"([^\"]*)\" and adults \"([^\"]*)\"$")
    public void findHotelsInCity(String city, int countRooms,int countAdults ) {
        LocalDate inDate = LocalDate.now().plusDays(3);
        LocalDate outDate = LocalDate.now().plusDays(4);
        bookingPage.setInitialData(city, inDate, outDate, countRooms, countAdults);
    }

    @Then("^I see a list of hotels that match the parameters$")
    public void seeHotelList()
    {
        assertTrue(bookingPage.getHotelList().size() > 0);
    }

    @When("^I sort list of hotel by rating and get first hotel$")
    public void findBestHotel( ) {
        bookingPage.sortByRating();
        bookingPage.getHotelList().get(0).click();
        driver.switchTo().activeElement();
    }

    @Then("^I see the best hotel with expected \"([^\"]*)\"$")
    public void seeHotelWithExpectedRating(int rating)
    {
        assertTrue(bookingPage.getHotelRating() >= rating);
    }

    @After
    public void afterClass() {
        driver.close();
    }
}