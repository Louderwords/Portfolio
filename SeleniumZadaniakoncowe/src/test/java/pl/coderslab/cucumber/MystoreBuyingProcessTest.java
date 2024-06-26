package pl.coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber/mystore-buying-process.feature",
        plugin = {"pretty", "html:BuyProduct_test_report.html"}
)

public class MystoreBuyingProcessTest {
}
