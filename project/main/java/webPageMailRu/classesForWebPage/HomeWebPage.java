package webPageMailRu.classesForWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class HomeWebPage {

    private static final int TIMEOUT = 10;

    abstract public void checkPage();

    protected void setExplicitWait(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
