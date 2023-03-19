package ru.regard.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"ru/regard/framework/steps", "ru/regard/framework/hooks"},
        features = {"src/test/resources/"},
        tags = {"@firstTest"}
)

public class CucumberRunner {
}
