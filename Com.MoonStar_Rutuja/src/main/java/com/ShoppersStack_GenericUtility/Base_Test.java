package com.ShoppersStack_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack_POM.Home_Page;
import com.ShoppersStack_POM.Login_Page;
import com.ShoppersStack_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public File_Utility fileUtility = new File_Utility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public WebDriverWait wait;
	public Home_Page homePage;
	public WebDriver_Utility webDriverUtility=new WebDriver_Utility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
		spark=new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test=reports.createTest("Demo");
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");
		
		String Browser=fileUtility.readDataFromPropertyFile("browserName");
		String url=fileUtility.readDataFromPropertyFile("url");
		
		//String Browser=System.getProperty("Browser");
		//String url=System.getProperty("url");
		if(Browser.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.contains("edge")) {
			driver=new EdgeDriver();
		}else if(Browser.contains("FireFox")) {
			driver=new FirefoxDriver();
		}else {
			System.out.println("Enter valid Browser Name");
		}
		sDriver=driver;
		homePage=new Home_Page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
	}
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("@BeforeMethod");
		welcomePage=new Welcome_Page(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginBtn()));
		Thread.sleep(2000);
		
		welcomePage.getLoginBtn().click();
		
		loginPage=new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();
	}
	@AfterMethod
	public void aftereMethod() throws InterruptedException {
		System.out.println("@AftereMethod");
		
		homePage.getAccountSettingsBtn().click();
		Thread.sleep(2000);
		homePage.getLogOutBtn().click();
	}
	@AfterClass
	public void aftereClass() throws InterruptedException {
		System.out.println("@AftereClass");
		Thread.sleep(2000);
		driver.quit();
	}
	@AfterTest
	public void aftereTest() {
		System.out.println("@AftereTest");
		reports.flush();
		
	}
	@AfterSuite
	public void aftereSuite() {
		System.out.println("@AftereSuite");
		
	}
}
