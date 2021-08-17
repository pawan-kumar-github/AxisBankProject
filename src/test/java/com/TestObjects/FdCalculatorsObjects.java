package com.TestObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FdCalculatorsObjects {
	public static WebElement element;
	public static List<WebElement> list;
	public static WebDriver driver;	
	
	
	public static WebElement Senior_Citizen(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='flRight' and @for='radio2']"));
		return element;	
	}
	
	public static WebElement Depoosit_Type(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\\'FdepType\\']"));
		return element;	
	}
	
	public static WebElement Amount(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\'loan_amount\']"));
		return element;	
	}
	
	
	public static WebElement AnyWhereOnScreen(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\'ctl00_Body_C022_Col00\']/div/div[3]/div[2]/div[1]/div/article[2]/div/div[1]"));
		return element;	
	}
	
	public static WebElement InterestValue(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='matIntRate']"));
		return element;	
	}
	

}
