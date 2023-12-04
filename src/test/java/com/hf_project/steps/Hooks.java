package com.hf_project.steps;
import com.hf_project.utilities.ConfigurationReader;
import com.hf_project.utilities.DB_Util;
import com.hf_project.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static io.restassured.RestAssured.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;


public class Hooks {


    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

       Driver.closeDriver();

    }

    @Before("@api")
    public void init() {

        baseURI = ConfigurationReader.getProperty("");

    }

    @After("@api")
    public void destroyAPI() {
        reset();
    }

    @Before("@db")
    public void setUpDB() {
        System.out.println("Connecting to database...");
        DB_Util.createConnection();
    }

    @After("@db")
    public void tearDownDB() {
        System.out.println("close database connection...");
        DB_Util.destroy();
    }



}
