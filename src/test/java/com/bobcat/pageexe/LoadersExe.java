package com.bobcat.pageexe;

import com.bobcat.baseclass.BaseClass;
import com.bobcat.locators.LoadersLocators;

public class LoadersExe extends HomePageExe {
	public static void loaders() {
		BaseClass.listofelements(new LoadersLocators().getAlloaders());
	}

}
