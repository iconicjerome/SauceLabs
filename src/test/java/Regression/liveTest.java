package Regression;

import PageObjects.ProductPage;
import Utils.Globals;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class liveTest extends Globals {


    @Test(priority = 0)
    public void testTextChange(){
        ExtentTest test = extent.createTest("User Purchase Test", "This test covers the User purchase feature").assignDevice("Windows").assignAuthor("Chukwuka");
        try {
            test.info("User is on product page");
            ProductPage productPage = new ProductPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            String addToCartText = productPage.add_to_cart_btn.getText();
            System.out.println(addToCartText);
            wait.until(ExpectedConditions.visibilityOf(productPage.add_to_cart_btn));
            test.info("Add to Cart button is visible");
            productPage.add_to_cart_btn.click();
            test.info("Add to Cart button has been clicked");
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(addToCartText.equals("Remove"));
            System.out.println(addToCartText);
            test.pass("Product selected successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void testItemAddedToCart(){
        ExtentTest test = extent.createTest("Item Added Test", "This test covers the User purchase feature").assignDevice("Windows").assignAuthor("Chukwuka");
        ProductPage productPage = new ProductPage(driver);
        productPage.add_to_cart_btn2.click();
        try {
            driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
            test.pass("Item has been added to cart");
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }

    }


}
