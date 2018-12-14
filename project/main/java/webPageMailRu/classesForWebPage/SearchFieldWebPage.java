package webPageMailRu.classesForWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchFieldWebPage extends HomeWebPage {

    @FindBy(xpath = ".//*[@class='light-link']")
    private List<WebElement> resultList;

    @FindBy(id = "js-icard-imgs")
    private WebElement imageResult;

    public SearchFieldWebPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
    }

    @Override
    public void checkPage() {
        imageResult.isDisplayed();
    }

    public List<WebElement> getResultList() {
        return resultList;
    }

    public boolean checkResult(String expected) {
        return imageResult.isDisplayed()
                && resultList.get(0).getText().contains(expected);


    }
}
