package webPageMailRu.classesForWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class LogInWebPage extends HomeWebPage {
    private static final int LINK_PRESENCE_TIMEOUT = 10;

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='mailbox:login']")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;

    @FindBy(id = "q")
    private WebElement search;

    @FindBy(id = "search:submit")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Картинки')]")
    private WebElement imageLink;

    @FindBy(xpath = ".//*[@class='images__image-pic']")
    private List<WebElement> imageList;

    private SearchFieldWebPage SearchPage;


    public LogInWebPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }

    public void enterLoginAndPass(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Override
    public void checkPage() {
        assert loginField.isDisplayed();
        assert passwordField.isDisplayed();
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean isLogoutLinkPresents() {
        return logoutLink.isDisplayed();
    }


    public boolean logoutLinkPresents() {
        return (new WebDriverWait(driver, LINK_PRESENCE_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(logoutLink))
                .isDisplayed();
    }

    public boolean logoutLinkErrorPresents() {
        return (new WebDriverWait(driver, LINK_PRESENCE_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed();
    }

    public void clickLogoutButton() {
        logoutLink.click();
    }

    public WebElement getSearch() {
        return search;
    }

    public SearchFieldWebPage clickButtonSearch() {
        searchButton.click();
        return SearchPage;
    }

    public void clickImageLink() {
        imageLink.click();
    }

    public List<WebElement> getImageList() {
        return imageList;
    }
}
