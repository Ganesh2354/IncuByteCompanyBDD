package com.incubyte.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement elementToClick=wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementToClick;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement elementToClick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		return elementToClick;
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement presentelement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
		return presentelement;
	}
	
	public static WebElement waitForVisibiltyOfElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement visibleElement=wait.until(ExpectedConditions.visibilityOf(element));
		return visibleElement;
	}
	
	public static WebElement waitForVisibiltyOfElement(WebDriver driver, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement visibleElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		return visibleElement;
	}
	
	
	public static List<WebElement> waitForVisibiltyOfAllElement(WebDriver driver, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		List<WebElement> visibleElement=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(path)));
		return visibleElement;
	}
	
	public static List<WebElement> waitForPresenceOfAllEleemnt(WebDriver driver, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		List<WebElement> visibleElement=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
		return visibleElement;
	}

}
