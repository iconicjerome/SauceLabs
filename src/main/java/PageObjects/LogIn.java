package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
    WebDriver driver;
    public LogIn (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#user-name")
    public WebElement username_field;
    @FindBy(css = "#password")
    public WebElement password_field;
    @FindBy(css = "#login-button")
    public WebElement login_button;
}
