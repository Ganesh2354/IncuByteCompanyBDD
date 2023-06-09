package com.incubyte.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakesScreenShot {

	
	public static void getScreenshot(WebDriver driver, String name)
	{
		try {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String userdir="user.dir";
		String path="C:\\Users\\Ganesh Dandekar\\Eclipse2023-03\\IDE\\eclipse-workspace\\IncubyteCo\\Screenshots\\"+name+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
}
