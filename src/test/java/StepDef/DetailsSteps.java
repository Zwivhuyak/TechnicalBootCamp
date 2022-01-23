package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DetailsSteps {

    private String CandidateName;

    @Given("^The user has been directed to the details dashboard$")
    public void the_user_has_been_directed_to_the_details_dashboard() throws Throwable {

        System.out.println("Candidate in the details dashboard");

    }

    @When("^What is your name ? (.+)$")
    public void what_is_your_name_(String name) throws Throwable {
        CandidateName =  name;

    }

    @Then("^Confirm the name$")
    public void confirm_the_name() throws Throwable {

        Assert.assertEquals("Zwivhuya",CandidateName);

    }
}
