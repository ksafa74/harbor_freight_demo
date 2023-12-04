package com.hf_project.steps;

import com.hf_project.pages.HomePage;
import com.hf_project.pages.OrdersPage;
import com.hf_project.pages.RegistrationPage;
import com.hf_project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StepDefs_US01 {

    HomePage homePage = new HomePage();
    OrdersPage ordersPage = new OrdersPage();
    RegistrationPage registrationPage =new RegistrationPage();



    @Given("user is on registration page with URL {string}")
    public void user_is_on_registration_page_with_url(String expectedUrl) {

        homePage.createAccount();

        Assert.assertEquals(expectedUrl,registrationPage.actualUrl());

    }
    @When("the user enters valid {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_valid(String firstName, String lastName, String email, String password, String phoneNumber) {

        registrationPage.fillRegistration(firstName,lastName,email,password,password,phoneNumber);

    }
    @When("clicks on the Create Account button")
    public void clicks_on_the_button(String string) {

        registrationPage.clickCreateAccountButton();

    }

    @When("should be redirected to the customer orders page URL {string}")
    public void should_be_redirected_to_the_customer_orders_page_url(String expectedUrl) {

        Assert.assertEquals(expectedUrl,ordersPage.actualUrl());

    }

    @Then("user should see that header account text is {string}")
    public void user_should_see_that_header_account_text_is(String expectedAccountText) {

        Assert.assertTrue(ordersPage.actualAccountText().equals(expectedAccountText));

    }

    @When("the user enters {string}, {string}, {string}, {string}, {string}")
    public void theUserEntersInvalid(String firstName, String lastName, String email, String password, String phoneNumber) {

        registrationPage.fillRegistration(firstName,lastName,email,password,password,phoneNumber);
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expectedMessage) {

        Assert.assertEquals(expectedMessage,registrationPage.actualErrorMessage());
    }

    @When("the user enters {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserEntersInvalid(String firstName, String lastName, String email, String password, String passwordConf, String phoneNumber) {

        registrationPage.fillRegistration(firstName,lastName,email,password,passwordConf,phoneNumber);
    }
}
