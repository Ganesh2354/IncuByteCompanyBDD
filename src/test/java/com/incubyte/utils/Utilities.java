package com.incubyte.utils;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {
	
	
	public static boolean areElementDisplayed(WebDriver driver, String path)
	{
		List<WebElement> all=SeleniumWaits.waitForVisibiltyOfAllElement(driver, path);
		boolean flag=true;
		 Iterator<WebElement> it=all.iterator();
		 while(it.hasNext())
		 {
			 if(!it.next().isDisplayed())
			 {
				 flag=false;
			 }
		 }
		
		 return flag;
	}
	
	public static void clickFromListOfElements(WebDriver driver, String path) {
		List<WebElement> all=SeleniumWaits.waitForPresenceOfAllEleemnt(driver, path);
		Iterator<WebElement> it=all.iterator();
		while(it.hasNext())
		{
		try {
			it.next().click();
		}catch(Exception e)
		{
			e.getMessage();
		}
		}
		
	}
	
	public static void clickFromListOfElementsAndSendValue(WebDriver driver, String path, String value) {
		List<WebElement> all=SeleniumWaits.waitForPresenceOfAllEleemnt(driver, path);
		Iterator<WebElement> it=all.iterator();
		while(it.hasNext())
		{
		try {
			it.next().click();
			it.next().sendKeys(value);
		}catch(Exception e)
		{
			e.getMessage();
		}
		}
		
	}

}
