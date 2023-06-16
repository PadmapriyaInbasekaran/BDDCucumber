package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.UtilitiesClass;

import java.util.Properties;

@RunWith(Cucumber.class)
public class loginStepDefinition {
    @Before(order = 2)        //Scenario Hooks
    public void beforeScenario() {
        System.out.println("This will run before the Scenario2");
    }

    @Before(order = 1, value = "smoke")
    public void beforeScenario2() {
        System.out.println("This will run before the Scenario");
    }

    @BeforeStep              //Step Hooks
    public void beforeStep() {
        System.out.println("This will run before the Step");
    }

    public static WebDriver driver;
    WebElement searchBar;
    WebElement cartButton;
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\testData.properties");

    @Given(": Open amazon.com")
    public void _open_amazoncom() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(locationPath.getProperty("amazon_url"));
        String amazonUrl = driver.getCurrentUrl();
        // Assert.assertEquals(amazonUrl,"https://www.amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
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
        Assert.assertEquals(driver.findElement(By.xpath(locationPath.getProperty("incorrect_phone_number_xpath"))).getText(), "Incorrect phone number");
        driver.close();
    }

    @AfterStep
    public void afterStep() {
        System.out.println("This will run after the Step");
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after the Scenario");
    }


    @When("^: Enter (.+) and click login$")
    public void _enter_and_click_login(String mobileNumber) {
        driver.findElement(By.xpath(locationPath.getProperty("signin_xpath"))).click();
        driver.findElement(By.xpath(locationPath.getProperty("enter_mobile_number_xpath"))).sendKeys(mobileNumber);
        driver.findElement(By.xpath(locationPath.getProperty("continue_button_xpath"))).click();
    }

    @Then("^: Incorrect phone number message should be visible$")
    public void _incorrect_phone_number_message_should_be_visible() {
        String errorMessage = driver.findElement(By.xpath(locationPath.getProperty("incorrect_phone_number_xpath"))).getText();
        Assert.assertEquals(errorMessage, "Incorrect phone number");
        driver.findElement(By.xpath(locationPath.getProperty("amazon_logo_xpath"))).click();
    }

    @Given("^: Locate the searchbar$")
    public void locate_the_searchbar() {
        searchBar = driver.findElement(By.xpath(locationPath.getProperty("searchbar_xpath")));
    }

    @When("^: Enter required mobile name in the searchbar$")
    public void enter_required_mobile_name_in_the_searchbar() {
        searchBar.sendKeys("redmi");
    }

    @Then("^: Results page should be displayed$")
    public void results_page_should_be_displayed() {
        Assert.assertEquals(driver.findElement(By.xpath(locationPath.getProperty("result_text_xpath"))).getText(), "Results");
    }

    @And("^: click on search$")
    public void click_on_search() {
        driver.findElement(By.xpath(locationPath.getProperty("searchicon_xpath"))).click();
    }

    @Given("^: click on link$")
    public void _click_on_link() {
        driver.findElement(By.xpath(locationPath.getProperty("mobile_link_xpath"))).click();
    }

    @When("^: Find add to cart button$")
    public void _find_add_to_cart_button() throws InterruptedException {
        Thread.sleep(2000);
        cartButton = driver.findElement(By.xpath(locationPath.getProperty("add_to_cart_xpath")));
    }

    @Then("^: Verify item added to cart$")
    public void _verify_item_added_to_cart() throws InterruptedException {
        Thread.sleep(2000);
        String cart_items = driver.findElement(By.xpath(locationPath.getProperty("cart_item_xpath"))).getText();
        Assert.assertEquals(cart_items, "1");
    }

    @And("^: click$")
    public void _click() {
        cartButton.click();
    }

    @And("^: click on deliver to India$")
    public void _click_on_deliver_to_india() {
        driver.findElement(By.xpath(locationPath.getProperty("location_xpath"))).click();
    }

    @And("^: Enter (.+) in the textBox$")
    public void _enter_in_the_textBox(String uszipcode) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(locationPath.getProperty("pincode_textbox_xpath"))).sendKeys(uszipcode);
    }

    @And("^: Click Apply$")
    public void _click_Apply() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(locationPath.getProperty("apply_button_xpath"))).click();
    }

    @And("^: click continue$")
    public void _click_continue() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath(locationPath.getProperty("continuebutton_xpath"))).click();
    }

    @Given("^: click on the cart icon$")
    public void _click_on_the_cart_icon() throws Throwable {
        driver.findElement(By.xpath(locationPath.getProperty("cart_item_xpath"))).click();
    }

    @When("^: click delete under the product$")
    public void _click_delete_under_the_product() throws Throwable {
        driver.findElement(By.xpath(locationPath.getProperty("delete_item_xpath"))).click();
    }

    @Then("^: Verify item removed from cart$")
    public void _verify_item_removed_from_cart() throws Throwable {
        String cart_items = driver.findElement(By.xpath(locationPath.getProperty("cart_item_xpath"))).getText();
        Assert.assertEquals(cart_items, "0");
    }

    @And("^: click on No thanks$")
    public void _click_on_no_thanks() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath(locationPath.getProperty("no_thanks_xpath"))).click();
    }

}