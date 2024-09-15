package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Globals {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static Properties properties;
    //Method to load properties file
    public static void loadProperties(){
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("resources/application.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties file." + e);
        }
    }
    //Method to get properties file keys
    public static String getProperty(String key){
        if(properties == null){
            loadProperties();
        }
        return properties.getProperty(key);
    }
    @BeforeSuite
    //start Browser
    public static WebDriver startBrowser(){
        loadProperties();
        String browser = getProperty("browser");
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(getProperty("app.url"));
        return driver;
    }
    @BeforeSuite
    //create Report
    public  static ExtentReports createReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/extent.html");
        spark.config().setDocumentTitle("SauceDemo Test");
        extent.attachReporter(spark);
        return extent;
    }
    @AfterSuite
    public void  closeBrowser() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        //use extent.flush() to generate report
        extent.flush();
        Thread.sleep(5000);
        driver.quit();
    }
    //Method to load excel sheet containing test data
    public static String getWorkbook1(int rowNum, int colNum) throws IOException {
        String projectPath =System.getProperty("user.dir");
        XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/Resources/testdata.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        String getData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return getData;
    }

}
