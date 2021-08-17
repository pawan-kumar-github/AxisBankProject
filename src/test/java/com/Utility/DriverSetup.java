package com.Utility;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverSetup {
	
	public static WebDriver driver;																				//THE DRIVER OF TYPE WEBDRIVER IS DECLARED GLOBALLY
	
	public static Properties prop = GetPrpoerty.getProperties();											//THIS WILL CREATE THE INSTANCE OF THE PROPERTIES FILE
	public static String baseURL = prop.getProperty("URL");														//THIS WILL FETCH THE VALUE OF THE URL FROM THE PROPERTIES FILE
	
	@SuppressWarnings("deprecation")
	public static WebDriver getWebDriver(String browser) throws MalformedURLException {											
		
		//DRIVER TO RUN CHROME BROWSER
				if (browser.equalsIgnoreCase("Chrome")) 
				{
	
							// Run successfully																						//THIS WILL DISABLE IN-BUILT NOTIFICATIONS OF THE CHROME BROWSER
					
//					System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Driver91\\chromedriver.exe");
//					ChromeOptions options = new ChromeOptions();												//THIS WILL CREATE THE OBJECT OF THE CHROMEOPTIONS CLASS
//					options.addArguments("disable-notifications");
//					//options.addArguments("--incognito");
//		            //options.setBinary("C:\Program Files\Google\Chrome\Application\chrome.exe");
//					//options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
////					DesiredCapabilities capabilities = new DesiredCapabilities();
////					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//					driver=new ChromeDriver(options);
					
					
					//Binary   Run Successfully
					
//					System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Driver91\\chromedriver.exe");
//					ChromeOptions options = new ChromeOptions();
//					options.addArguments("disable-notifications");
//				    options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//				    driver=new ChromeDriver(options);
				    
				    
				                                                  // Configuring driver via maven dependency
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-notifications");
					driver=new ChromeDriver(options);
					
				} 
				
		//DRIVER TO RUN MOZILLA FIREFOX BROWSER
				else if (browser.equalsIgnoreCase("firefox")) 
				{
				
					//FirefoxOptions options = new FirefoxOptions();												//THIS WILL CREATE THE OBJECT OF THE FIREFOXOPTIONS CLASS
					//options.addPreference("dom.webnotifications.enabled",false);								//THIS WILL DISABLE IN-BUILT NOTIFICATIONS OF THE FIREFOX BROWSER
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);				//THIS WILL CREATE THE INSTANCE OF THE REMOTE WEBDRIVER TO BE ACCESSED FROM SELENIUM GRID
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Drivers\\geckodriver.exe");
					//driver=new FirefoxDriver();
					
					//Firefox Binary Path issue Code  Run Successfully
					File pathBinary = new File("C:\\Users\\pawan\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
					DesiredCapabilities desired = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
				    driver = new FirefoxDriver(options);
				}
				
		//DRIVER TO RUN MICROSOFT EDGE BROWSER
				else if (browser.equalsIgnoreCase("edge"))
				{
					
					EdgeOptions options = new EdgeOptions();													//THIS WILL CREATE THE OBJECT OF THE EDGEOPTIONS CLASS
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
					System.setProperty("webdriver.edge.driver","C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Drivers\\msedgedriver.exe");
					driver = new EdgeDriver();																	//THIS WILL CREATE THE INSTANCE OF THE REMOTE WEBDRIVER TO BE ACCESSED FROM SELENIUM GRID
					
					
				}
				else {
					//String path=System.getProperty("user.dir");
					System.setProperty("webdriver.ie.driver","C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Drivers\\IEDriverServer.exe");
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					capability.setCapability("ignoreZoomSetting",true);
					capability.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
					
					driver=new InternetExplorerDriver(capability);
				}
//				
		
				
		driver.manage().window().maximize();																	//THIS WILL MAXIMIZE THE BROWSER WINDOW UPON LOADING
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);										//THIS WILL MAKE THE WEBPAGE WAIT FOR A MAXIMUM OF TEN SECONDS BEFORE LOADING IT SUCCESSFULLY
		driver.get(baseURL);																					//THIS WILL RETURN THE URL OF THE WEBSITE TO THE DRIVER
		return driver;																							//THIS WILL RETURN THE DRIVER UPON CALLING 
	}
	
	public static void driverClose(WebDriver driver) {
		driver.close();																							//THIS WILL CLOSE THE DRIVER
	}	
}
