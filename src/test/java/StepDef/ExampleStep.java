package StepDef;

import io.cucumber.java.en.Given;
import org.junit.Assert;

public class ExampleStep {

    @Given("Example")
    public void method() throws InterruptedException {

        Assert.assertEquals("mna","mna");

        System.out.println("Inside shashshsh");
    }
}
