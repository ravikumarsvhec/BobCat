package com.bobcat.pageexe;

import com.bobcat.baseclass.BaseClass;
import com.bobcat.locators.HomePageLocators;
import com.bobcat.locators.LoadersLocators;

public class HomePageExe extends LoadersLocators {
	public static void homepage() throws InterruptedException {
		BaseClass.click(new HomePageLocators().getAcceptcookies());
		sleep();
		BaseClass.click(new HomePageLocators().getEquipment());
		BaseClass.click(new HomePageLocators().getViewloader());
	}

}
