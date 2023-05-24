package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class printNumber {

    @Given(": Assume number")
    public void _assume_number() {
      System.out.println("Assume a number");
    }


    @Then(": Verify number is printed on the console")
    public void _verify_number_is_printed_on_the_console() {
        System.out.println("Number is entered on the console");
    }

    @When(": Enter number {int} in the console")
    public void enterNumberInTheConsole(int number) {
        System.out.println(number);
    }
}