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

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("List product page saucedemo")
    public void list_product_page_saucedemo(){
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

    @When("User click empty cart icon")
    public void userClickEmptyCartIcon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("Page Your Cart is displayed")
    public void pageYourCartIsDisplayed() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Your Cart");
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("Error message cart cannot empty")
    public void errorMessageCartCannotEmpty() {driver.findElement(By.id("alert-error")).isDisplayed();

    }
}
