package com.hf_project.pages;

import com.hf_project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends BasePage {

    public OrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Shop Now']")
    private WebElement shopNowTab;

    @FindBy(xpath ="//span[@class='my-account__text--yfDSxn']")
    private WebElement myAccountText;

    public String actualUrl(){

        return Driver.getDriver().getCurrentUrl();
    }


    public String actualAccountText(){

        return myAccountText.getText();


    }
}
