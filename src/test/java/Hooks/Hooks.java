package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;

public class Hooks {

    @Before
    public void startOfClass(){
        System.out.println("Do something from this class");
    }

    @After
    public void endOfClass(){
        System.out.println("We done");
    }
}
