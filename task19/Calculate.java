package tests.task19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.plugin.extension.JavaExtensionInstaller;

import java.util.List;

public class Calculate {
    public static void main(String[] args) {
        //String exePath = "D:\\java_code\\selenium-java-3.141.5\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mail.ru");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]"));
        executor.executeScript("arguments[0].style.backgroundColor='red';",element);


        /*WebElement searchLine = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        searchLine.click();
        searchLine.sendKeys("Погода Минск");
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[3]/center/input[1]"));
        searchButton.click();
        //searchButton.click();
        WebElement link = driver.findElement(By.partialLinkText("www.gismeteo.by"));
        link.click();
        List<WebElement> tomorrow = driver.findElements(By.xpath(".//span[normalize-space(text())='Завтра']"));
        tomorrow.get(0).click();

        WebElement weather = driver.findElement(By.partialLinkText("//html/body/section/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div/div[3]/div/div/div/div[5]"));
        System.out.println(weather.getText());*/
        //driver.close();
    }
}
