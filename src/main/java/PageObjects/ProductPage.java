package PageObjects;

import org.openqa.selenium.By;
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
    @FindBy(css = "#shopping_cart_container > a > span")
    public By item_added_to_cart;

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    public WebElement add_to_cart_btn2;
    @FindBy(className = "inventory_item_name")
    public WebElement product_name;
    @FindBy(className = "inventory_item_desc")
    public WebElement product_description;

    @FindBy(className = "inventory_item_price")
    public WebElement product_amount;

}
