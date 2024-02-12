package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    public WebElement first_name;
    @FindBy(xpath = "//*[@id=\"last-name\"]")
    public WebElement last_name;
    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    public WebElement postal_code;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continue_btn;
}
