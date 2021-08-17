package com.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.TestObjects.FdCalculatorsObjects;
import com.Utility.DataFromExcel;

public class TestFunctions {
	

	public static WebDriver driver;
	
	
	/*public static void CloseAlertAndPopup(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}*/
	public static void ScrollDown(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\'ctl00_Body_C022_Col00\']/div/div[3]/div[1]/div/h1")));
		
	}
	
	public static void SelectSeniorCitizenRadioButton(WebDriver driver) {
		
		FdCalculatorsObjects.Senior_Citizen(driver).click();
		
	}
	
	public static void SelectDepositeType(WebDriver driver) {
		Select DepositeType = new Select(driver.findElement(By.xpath("//*[@id=\'FdepType\']")));
		DepositeType.selectByIndex(2);
	}
	
	public static void EnterAmount(WebDriver driver) throws Exception {
		FdCalculatorsObjects.Amount(driver).clear();
		FdCalculatorsObjects.Amount(driver).sendKeys("40000");
	}
	
	public static void EnterAnywhereonScreen(WebDriver driver) {
		
		FdCalculatorsObjects.AnyWhereOnScreen(driver).click();
	}

	public static void PrintRateofInterest(WebDriver driver) {
		
		String RateofInterest=FdCalculatorsObjects.InterestValue(driver).getText();
		System.out.println(RateofInterest);
	}
}

