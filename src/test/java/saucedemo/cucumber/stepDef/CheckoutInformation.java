package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutInformation {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Checkout page with information user input field")
    public void checkout_page_with_information_user_input_field(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User typed first name")
    public void userTypedFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Diki");
    }

    @When("User typed last name")
    public void userTypedLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Hendri");
    }

    @And("User typed zip or postal code")
    public void userTypedZipPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("17540");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Checkout overview page displayed")
    public void checkoutOverviewPageDisplayed() {
        driver.findElement(By.className("summary_info_label")).isDisplayed();
    }
}
