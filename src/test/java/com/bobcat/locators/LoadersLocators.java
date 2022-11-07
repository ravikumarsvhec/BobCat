package com.bobcat.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadersLocators extends HomePageLocators{
	public LoadersLocators() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@data-test-id='product-listing-item__content']")
	private List<WebElement> allloaders;
	public List<WebElement> getAlloaders() {
		return allloaders;
	}
	

}
