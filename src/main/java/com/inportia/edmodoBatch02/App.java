package com.inportia.edmodoBatch02;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "Features",
	glue     = "com/inportia/stepDefinitions",
	tags      = { "@wip" , "~@skip" },
    format = { "pretty", "html:target/cucumber", "json:target_json/cucumber.json"}
)

public class App
{

	
	
}
