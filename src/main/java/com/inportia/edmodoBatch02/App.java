package com.inportia.edmodoBatch02;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "Features",
	glue     = "com/inportia/stepDefinitions"
)

public class App 
{
    
}
