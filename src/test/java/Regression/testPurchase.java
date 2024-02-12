package Regression;

import PageObjects.*;
import Utils.Globals;
import org.testng.annotations.Test;

public class testPurchase extends Globals {


    @Test
    public void testPurchase(){
        ProductPage productPage = new ProductPage(driver);
        CloseOutPage closeOutPage = new CloseOutPage(driver);
        OrderDetails orderDetails = new OrderDetails(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AppreciationPage appreciationPage = new AppreciationPage(driver);
        try {
            productPage.add_to_cart_btn.click();
            productPage.cart_btn.click();
            orderDetails.checkout_btn.click();
            checkoutPage.first_name.sendKeys("Odumodu");
            checkoutPage.last_name.sendKeys("Blvck");
            checkoutPage.postal_code.sendKeys("12345");
            checkoutPage.continue_btn.click();
            closeOutPage.finish_btn.click();
            appreciationPage.back_home_btn.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform purchase", e);
        }
    }
}
