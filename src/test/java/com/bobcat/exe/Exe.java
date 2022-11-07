package com.bobcat.exe;

import com.bobcat.pageexe.LoadersExe;

public class Exe extends LoadersExe {
	public static void main(String[] args) throws InterruptedException {
		browserlaunch();
		implicitwait();
		url("https://www.bobcat.com/in/en");
		homepage();
		loaders();
		
	}
	

}
