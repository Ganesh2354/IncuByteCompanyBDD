package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// Please run the feature file as Cucumber Feature
		
		features= {"C:\\Users\\Ganesh Dandekar\\Eclipse2023-03\\IDE\\eclipse-workspace\\IncubyteCo\\src\\test\\resources\\ComposeFeatureFile\\GmailComposeFunctionality.feature"},
		
		glue= {"GmailComposeFunctionality.java"},
		
		dryRun=true,
		
		monochrome=true
		
		
		
		)


public class TestRunner {

}
