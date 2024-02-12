package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Globals {
    public static WebDriver driver;
    @BeforeSuite
    public static WebDriver startBrowser(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        return driver;
    }
    @AfterSuite
    public void  closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
