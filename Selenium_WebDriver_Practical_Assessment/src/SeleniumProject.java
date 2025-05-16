import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumProject {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "O:\\Balaji Automation Assessment\\Selenium Assessment\\Selenium_WebDriver_Practical_Assessment\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        System.out.println("Page Title: " + driver.getTitle());
        driver.quit();
    }
}
