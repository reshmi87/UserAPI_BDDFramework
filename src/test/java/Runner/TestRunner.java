package Runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", "html:Reports/cucumber-reports.html",
				"json:Reports/cucumber-reports.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		monochrome=false, 
		tags = "@post",
		features = {"src/test/resources/features"}, 
		glue= {"StepDefinition"}) 


public class TestRunner extends AbstractTestNGCucumberTests{

	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
	}
}
