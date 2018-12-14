package testsForMailRu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webPageMailRu.setting.Config;
import webPageMailRu.setting.Parameters;
import webPageMailRu.setting.DomParameters;
import webPageMailRu.classesForWebPage.LogInWebPage;
import webPageMailRu.classesForWebPage.SearchFieldWebPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.xml.sax.SAXException;
import ru.yandex.qatools.allure.annotations.Attachment;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestsForSearchField extends Config {
    private static final Logger logger = Logger.getLogger(TestsForSearchField.class);
    private static final DomParameters parser = new DomParameters();
    private LogInWebPage loginPage;
    private SearchFieldWebPage searchPage;
    private Parameters parameters;

    public TestsForSearchField() throws IOException, SAXException, ParserConfigurationException {
        initDriver();
        loginPage = new LogInWebPage(driver);
        searchPage = new SearchFieldWebPage(driver);
        parameters = parser.parse();
        logger.info("set param for page.");
    }

    @Given("^I am on main page$")
    public void loadMainPage() {
        driver.get(url);
        logger.info("I am on main application page the url " + url);
    }

    @When("^I enter text in search bar and click search button$")
    public void enterTextInSearchBar() {
        loginPage.getSearch().sendKeys(parameters.getTextForSearch());
        loginPage.clickButtonSearch();
        logger.info("I enter text in search bar and click search button");
    }

    @Then("I see valid search result")
    public void seeResult() {
        Assert.assertTrue(searchPage.checkResult(parameters.getTextForSearch()),
                "Result is not correct.");
        logger.info("I see valid search result");
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void afterClass() {
        makeScreenshot();
        closeDriver();
        logger.info("test are finish.");
    }

}
