package StepDef;

import io.cucumber.java.en.Given;
import org.junit.Assert;

public class ExampleStep {

    @Given("Example")
    public void method() throws InterruptedException {

        Assert.assertEquals("mna","mna");
        Thread.sleep(70000);
        System.out.println("Inside shshshsh");
    }
}
