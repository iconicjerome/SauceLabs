package Regression;

import PageObjects.LogIn;
import Utils.Globals;
import org.testng.annotations.Test;

public class testLogIn extends Globals {
    LogIn logIn;
    @Test
    public void testLogin() throws InterruptedException {
        try {
            logIn = new LogIn(driver);
            logIn.username_field.sendKeys("standard_user");
            logIn.password_field.sendKeys("secret_sauce");
            Thread.sleep(3000);
            logIn.login_button.click();
        } catch (Exception e) {
             throw new RuntimeException("Failed to perform login", e);
        }
    }

}
