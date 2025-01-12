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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Globals {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static Properties properties;
    //Create method to access application.properties file
    public  static  void loadProperties(){
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("resources/application.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Create Method to get properties
    public static String getProperties(String key){
        if(properties==null){
            loadProperties();
        }
        return properties.getProperty(key);
    }
    @BeforeSuite
    //start Browser
    public static WebDriver startBrowser(){
        String browser = getProperties("browser");
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("'firefox'")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        return driver;
    }
    @BeforeSuite
    //create Report
    public  static ExtentReports createReport(){
        //Add date and time to extent report;
        //use this format "dd-mm-yyyy_hh-mm-ss" to prevent the java.nio.file.InvalidPathException: Illegal char exception
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        String newDate = dateFormat.format(date);
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Report-"+newDate+".html");
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
    public static String getWorkbook1(int rowNum, int colNum) throws IOException {
        String projectPath =System.getProperty("user.dir");
        XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/Resources/testdata.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        String getData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return getData;
    }
}
