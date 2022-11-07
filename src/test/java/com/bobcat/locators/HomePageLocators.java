package com.bobcat.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bobcat.baseclass.BaseClass;

public class HomePageLocators extends BaseClass {
	public HomePageLocators(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="onetrust-accept-btn-handler")
	private WebElement acceptcookies;
	public WebElement getAcceptcookies() {
		return acceptcookies;
	}
	@FindBy(xpath="//div[text()='Equipment']")
	private WebElement equipment;
	public WebElement getEquipment() {
		return equipment;
	}
	@FindBy(linkText="View All Loaders")
	private WebElement viewloader;
	public WebElement getViewloader() {
		return viewloader;
	}
	

}
