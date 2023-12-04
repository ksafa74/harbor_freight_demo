package com.hf_project.pages;

import com.hf_project.utilities.BrowserUtil;
import com.hf_project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//div/span[.='Shop'])[2]")
    private WebElement shopTab;

    @FindBy(id = "search-input")
    private WebElement searchBar;



    public WebElement shopTabSubTabs(String shopTabName) {

        BrowserUtil.hover(shopTab);

        return Driver.getDriver().findElement(By.xpath("(//a[normalize-space(text())='" + shopTabName + "'])[2]"));


    }

    public WebElement presentationTabs(String headerName) {

        return Driver.getDriver().findElement(By.xpath("(//a[normalize-space(text())='" + headerName + "'])[2]"));

    }


}
