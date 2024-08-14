package Regression;

import PageObjects.LogIn;
import Utils.Globals;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class testLogIn extends Globals {
    LogIn logIn;
    @Test
    public void testLogin() throws InterruptedException {
        ExtentTest test = extent.createTest("LogIn User Test", "This test covers the User LogIn feature").assignDevice("Windows").assignAuthor("Chukwuka");
        try {
            //use test.info to log info on the report
            test.info("User is on login page");
            logIn = new LogIn(driver);
            logIn.username_field.sendKeys("standard_user");
            test.info("User inputs username successfully");
            logIn.password_field.sendKeys("secret_sauce");
            test.info("User inputs password successfully");
            Thread.sleep(3000);
            logIn.login_button.click();
            test.info("User clicks login button successfully");
            test.pass("User was abel in login successfully");
        } catch (Exception e) {
            test.fail("User was not able to login" + e);
             throw new RuntimeException("Failed to perform login", e);

        }
    }

}
