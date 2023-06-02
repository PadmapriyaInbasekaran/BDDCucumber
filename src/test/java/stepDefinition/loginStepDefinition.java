package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.UtilitiesClass;
import java.util.Properties;

@RunWith(Cucumber.class)
public class loginStepDefinition {
    @Before(order = 2)        //Scenario Hooks
    public void beforeScenario(){
        System.out.println("This will run before the Scenario2");
    }

    @Before(order = 1, value = "smoke")
    public void beforeScenario2(){
        System.out.println("This will run before the Scenario");
    }
    @BeforeStep              //Step Hooks
    public void beforeStep(){
        System.out.println("This will run before the Step");
    }
    public static WebDriver driver;
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\testData.properties");

    @Given(": Open amazon.com")
    public void _open_amazoncom() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(locationPath.getProperty("amazon_url"));
        driver.manage().window().maximize();
    }

    @When("^: Enter (.*), (.*) and click login$")
    public void _enter_username_password_and_click_login(String username, String password) {
        driver.findElement(By.xpath(locationPath.getProperty("signin_xpath"))).click();
        driver.findElement(By.xpath(locationPath.getProperty("enter_mobile_number_xpath"))).sendKeys(username);
        driver.findElement(By.xpath(locationPath.getProperty("enter_mobile_number_xpath"))).sendKeys(password);
        driver.findElement(By.xpath(locationPath.getProperty("continue_button_xpath"))).click();
    }

    @Then(": Amazon homepage is visible$")
    public void _amazon_homepage_is_visible() {
        Assert.assertEquals(driver.findElement(By.xpath(locationPath.getProperty("incorrect_phone_number_xpath"))).getText(),"Incorrect phone number");
        driver.close();
    }

    @AfterStep
    public void afterStep(){
        System.out.println("This will run after the Step");
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}