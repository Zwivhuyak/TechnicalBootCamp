package StepDef;

import io.cucumber.java.en.Given;
import org.junit.Assert;

public class ExampleStep {

    @Given("Example")
    public void method() throws InterruptedException {

        Assert.assertEquals("mnaa","mna");

        System.out.println("Inside shshshsh");
    }
}
