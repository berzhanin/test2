package tests.task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Booking {
    public static void main(String[] args) {
        String exePath = "D:\\java_code\\selenium-java-3.141.5\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");
        WebElement searchLine = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        //searchLine.click();
        searchLine.sendKeys("Москва");
        WebElement people = driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]"));
        people.click();
        //WebElement children = driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]"));
        people.sendKeys("2");

        //driver.close();
    }
}
