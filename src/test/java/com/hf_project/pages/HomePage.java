package com.hf_project.pages;

import com.hf_project.utilities.BrowserUtil;
import com.hf_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Create Account']")
    private WebElement createAccountLink;

    @FindBy(xpath = "//span[@class='my-account__text--yfDSxn']")
    private WebElement myAccountTab;

    public void createAccount(){

        myAccountTab.click();
        createAccountLink.click();

    }

}
