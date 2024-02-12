package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    public WebElement add_to_cart_btn;
    @FindBy(css = "#shopping_cart_container > a")
    public WebElement cart_btn;
}
