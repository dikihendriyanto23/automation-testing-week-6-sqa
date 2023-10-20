package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src\\test\\java\\saucedemo\\cucumber\\resources\\features\\Checkout.feature"},
        glue= {"saucedemo.cucumber.stepDef"},
        plugin = {"html:target/HTML_reportCheckout.html"})
public class RunCheckout {

}
