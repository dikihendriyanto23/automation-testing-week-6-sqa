package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("List product page")
    public void list_product_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String title2 = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(title2, "Swag Labs");
    }

    @When("User click add to cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("Remove button displayed in selected product")
    public void remove_button_displayed_in_selected_product() {
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).isDisplayed();
    }

    @And("Cart icon displayed number of product added")
    public void cart_icon_displayed_number_of_product_added() {
        driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
    }

    @When("User click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("Your Cart page is displayed")
    public void your_cart_page_is_displayed() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Your Cart");
    }

    @And("A list of added products appears")
    public void a_list_of_added_products_appears() {
        driver.findElement(By.className("inventory_item_name")).isDisplayed();
    }
}
