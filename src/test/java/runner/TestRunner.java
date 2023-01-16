package runner;

 import io.cucumber.testng.AbstractTestNGCucumberTests;
 import io.cucumber.testng.CucumberOptions;

/**************************************************************************************************
 Author : Bintu Dhillon
 **************************************************************************************************/

@CucumberOptions(tags = "@Regression",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }, glue = "com.test.hudl.steps",
        features = "src/test/java/features/")
public class TestRunner extends AbstractTestNGCucumberTests {
}